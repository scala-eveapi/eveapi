package eveapi.http4sclient

import org.http4s._
import org.http4s.client.Client
import scalaz._, Scalaz._
import scalaz.concurrent.Task
import eveapi.data.crest.{Response => EveResponse, _}
import scalaz.stream.Process
import scodec.bits.ByteVector

case class Token(token: String)

object http4sclient {

  def bearer(request: Request, token: String) =
    request.putHeaders(Header("Authorization", s"Bearer ${token}"))

  def errorHandling[T](
    decoder: Response => T,
    errorDecoder: Response => EveException): Response => Task[EveException \/ T] = { response =>
    Task(
        response.status match {
          case Status.Ok => \/-(decoder(response))
          case _ => -\/(errorDecoder(response))
        }
    )
  }

  implicit def getr[T] = new GetRequester[Uri, T] {
    type Monad[S] = Kleisli[Task, (Client, Token, Response => Task[S]), S]
    type ErrorMonad[E, S] = E \/ S
    def get(href: Uri) = Kleisli {
      case (client, token, decoder) =>
        client.fetch(bearer(Request(uri = href, method = Method.GET), token.token))(decoder)
    }
  }

  def sendRequest[T, R](href: Uri, input: T, method: Method) =
    Kleisli[Task,
            (Client, Token, T => String, Response => Task[EveException \/ R]),
            EveException \/ R] {
      case (client, token, encoder, decoder) =>
        // :-(, but Task should catch it.
        val body = Process(ByteVector.encodeUtf8(encoder(input)).fold(x => throw x, x => x))
        client
          .fetch(bearer(Request(uri = href, method = method, body = body), token.token))(decoder)
    }
  implicit def putr[T] = new PutRequester[Uri, T] {
    type Monad[S] = Kleisli[
        Task, (Client, Token, T => String, Response => Task[EveException \/ UpdateResponse]), S]
    type ErrorMonad[E, S] = E \/ S
    def put(href: Uri, input: T) = sendRequest(href, input, Method.PUT)
  }
  implicit def postr[T] = new PostRequester[Uri, T] {
    type Monad[S] = Kleisli[
        Task, (Client, Token, T => String, Response => Task[EveException \/ CreationResponse]), S]
    type ErrorMonad[E, S] = E \/ S
    def post(href: Uri, input: T) = sendRequest(href, input, Method.POST)
  }
  implicit def deleter[T] = new DeleteRequester[Uri] {
    type Monad[S] =
      Kleisli[Task, (Client, Token, Response => Task[EveException \/ DeletionResponse]), S]
    type ErrorMonad[E, S] = E \/ S
    def delete(href: Uri) = sendRequest(href, (), Method.POST).local {
      case (client, token, decoder) => (client, token, _ => "", decoder)
    }
  }
}
