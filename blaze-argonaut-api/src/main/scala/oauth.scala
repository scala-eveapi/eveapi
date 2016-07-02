package eveapi.oauth

import org.atnos.eff._, org.atnos.eff.syntax.all._, org.atnos.eff.all._
import argonaut._, Argonaut._, Shapeless._
import scalaz._, Scalaz._
import scalaz.concurrent._
import scala.util.Random
import scala.io.Codec
import org.apache.commons.codec.binary.Base64
import org.http4s._, org.http4s.dsl._, org.http4s.client._, org.http4s.argonaut._,
org.http4s.util.{CaseInsensitiveString => CIS}
import java.time._
import java.time.temporal.ChronoUnit._
import org.log4s.getLogger

import eveapi.utils._
import TaskEffect._
import eveapi.errors._

case class OAuth2ClientSettings(
  loginPath: String
)

case class OAuth2Settings(
  authorizationUri: Uri,
  accessTokenUri: Uri,
  callbackUri: Uri,
  verifyUri: Uri,
  clientID: String,
  clientSecret: String,
  refreshUri: Uri,
  scope: Option[String]
)

case class OAuth2Token(
  access_token: String,
  token_type: String,
  expires_in: Int,
  refresh_token: String,
  generatedAt: Instant = Instant.now()
) {
  def expired(at: Clock) =
    Instant.now(at).isAfter(generatedAt.plus((expires_in * 0.9).toLong, SECONDS))
}

case class VerifyAnswer(
  CharacterID: Long,
  CharacterName: String,
  Scopes: String,
  TokenType: String,
  CharacterOwnerHash: String
)

// TODO convert to a State
case class OAuth2State(seed: Long) {
  val tokens = scala.collection.concurrent.TrieMap[String, Unit]()
  val rng = new Random(seed)
  def token = {
    val t = rng.alphanumeric.take(40).mkString("")
    tokens += ((t, ()))
    t
  }
  def popToken(token: String): EveApiError \/ Unit = {
    if (tokens.contains(token)) {
      tokens -= token
      \/-(())
    } else {
      -\/(StateNotFound(token, tokens.keySet.toSet))
    }
  }
}

case class ExchangeToken(code: String, state: String)

object OAuth2 {
  type EveApiS = Task |: (EveApiError \/ ?) |: State[OAuth2Token, ?] |: NoEffect
  type Api[T] = Eff[EveApiS, T]
  type A = EveApiS
}

case class OAuth2(client: Client,
                  settings: OAuth2Settings,
                  state: OAuth2State,
                  clock: Clock,
                  clientSettings: OAuth2ClientSettings) {
  import OAuth2._
  implicit def oauth2Decoder =
    DecodeJson({ c =>
      for {
        ac <- (c --\ "access_token").as[String]
        tt <- (c --\ "token_type").as[String]
        ei <- (c --\ "expires_in").as[Int]
        rt <- (c --\ "refresh_token").as[String]
      } yield OAuth2Token(ac, tt, ei, rt)
    })

  def redirectoToProvider[R]()(
    implicit t: Task <= R
  ): Eff[R, Response] =
    for {
      result <- innocentTask({
                 Found(
                     settings.authorizationUri
                       .withQueryParam("response_type", "code")
                       .withQueryParam("redirect_uri", settings.callbackUri.toString)
                       .withQueryParam("client_id", settings.clientID)
                       .withQueryParam("scope", settings.scope.getOrElse(""))
                       .withQueryParam("state", state.token))
               })
    } yield result

  def encodeAuth(settings: OAuth2Settings): Header = {
    val encodedAuth = Base64
      .encodeBase64String(Codec.toUTF8(s"${settings.clientID}:${settings.clientSecret}"))
      .toString
    Header("Authorization", s"Basic ${encodedAuth}")
  }

  def exchangeOAuthToken[R](exchange: ExchangeToken)(
    implicit t: Task <= R,
    d: EveApiError \/ ? <= R
  ): Eff[R, OAuth2Token] =
    for {
      response <- innocentTask[R, EveApiError \/ OAuth2Token]({
                   state
                     .popToken(exchange.state)
                     .fold(x => Task.now(x.left[OAuth2Token]), _ => {
                       client
                         .expect[OAuth2Token](POST // TODO handle denial
                               .apply(settings.accessTokenUri,
                                      UrlForm("grant_type" -> "authorization_code",
                                              "code" -> exchange.code))
                               .putHeaders(encodeAuth(settings)))(jsonOf[OAuth2Token])
                         .map(_.copy(generatedAt = Instant.now(clock)))
                     }.attempt.map(_.leftMap(ThrownException.apply)))
                 })
      result <- fromDisjunction(response)
    } yield result

  val callbackPath = settings.callbackUri.path.toString

  def oauthService[R](
    storeToken: OAuth2Token => Task[Response]): PartialFunction[Request, Task[Response]] = {
    case r @ GET -> Root / clientSettings.loginPath =>
      EffInterpretation.detach[Task, Response](
          redirectoToProvider[Task |: NoEffect]()
      )
    case r @ GET -> callbackPath => {
        val token = for {
          code <- r.params.get("code")
          state <- r.params.get("state")
        } yield ExchangeToken(code, state)
        Task.now {
          token.getOrElse {
            throw new ParseError(
                s"Couldn't find all parameters in the callback. Params: ${r.params}")
          }
        }.flatMap({ token =>
          exchangeOAuthToken[(EveApiError \/ ?) |: Task |: NoEffect](token).runDisjunction.detach
            .map(_.fold[OAuth2Token](err => throw err, x => x))
            .flatMap(storeToken)
        })
      }
  }

  private[this] val logger = getLogger

  def bearer(request: Request, token: String) =
    request.putHeaders(Header("Authorization", s"Bearer ${token}"))

  def refresh: Api[Unit] =
    for {
      token <- StateEffect.get[A, OAuth2Token]
      newToken <- task[A, OAuth2Token]({
                   client
                     .expect[OAuth2Token]( // TODO handle denial
                         POST(settings.refreshUri,
                              UrlForm("grant_type" -> "refresh_token",
                                      "refresh_token" -> token.refresh_token))
                           .putHeaders(encodeAuth(settings)))(jsonOf[OAuth2Token])
                     .map(_.copy(generatedAt = Instant.now(clock)))
                 })
      _ <- StateEffect.put[A, OAuth2Token](token)
    } yield ()

  def executeOAuth[T](request: Request, decoder: Response => Task[T]): Api[T] = {
    for {
      token <- StateEffect.get[A, OAuth2Token]
      _ <- if (token.expired(clock)) refresh else EffMonad[A].point(())
      fetch = client.fetch[(Status, String) \/ T](bearer(request, token.access_token))({
        response =>
          response.status match {
            case Status.Ok => decoder(response).map(\/-.apply)
            case _ => response.as[String].map(body => -\/((response.status, body)))
          }
      })
      maybeResponse <- task[A, (Status, String) \/ T](fetch)
      result <- maybeResponse match {
                 case -\/((Status.Unauthorized, _)) =>
                   refresh >> task[A, (Status, String) \/ T](fetch)
                     .map(_.leftMap[EveApiError]((EveApiStatusFailed.apply _).tupled))
                     .flatMap(fromDisjunction[A, EveApiError, T])
                 case \/-(resp) => task[A, T](Task.now(resp))
                 case -\/((status, body)) =>
                   fromDisjunction[A, EveApiError, T](-\/(EveApiStatusFailed(status, body)))
               }
    } yield result
  }

  def fetch[T: DecodeJson](request: Request): Api[T] =
    executeOAuth(request, _.as[String].map({ str =>
      logger.debug(s"Received body: $str")
      Parse.decode[T](str).fold(err => throw JsonParseError(err), x => x)
    }))
  def fetch[T: DecodeJson](request: Task[Request]): Api[T] =
    innocentTask[EveApiS, Request](request).flatMap(r => fetch(r))
  def fetch[T: DecodeJson](uri: Uri): Api[T] = fetch[T](Request(method = Method.GET, uri = uri))
  def verify: Api[VerifyAnswer] = fetch[VerifyAnswer](settings.verifyUri)
}