package eveapi

import eveapi.oauth._
import OAuth2._
import scalaz._, Scalaz._
import scalaz.concurrent.Task
import eveapi.errors._
import org.http4s._, org.http4s.dsl._
import org.http4s.server.Server
import org.http4s.server.blaze._
import org.atnos.eff._, org.atnos.eff.syntax.all._, org.atnos.eff.all._
import java.time.Clock
import java.util.concurrent.CountDownLatch


case class Yolo[T](api: Api[T]) {
  def deeff: Reader[(OAuth2, OAuth2Token), Task[\/[EveApiError, T]]] =
    Reader({case (oauth, token) =>
      Eff.detach[Task, \/[EveApiError, T]](api.runReader[OAuth2](oauth).runState(token).map(_._1).runDisjunction)
    })
  def yolo(implicit oauth: OAuth2, token: OAuth2Token): T =
    deeff.run((oauth, token)).unsafePerformSync.leftMap(err => throw err).merge
}

object Yolo {
  implicit def ApiOps[T](api: Api[T]) = Yolo(api)
  val client = org.http4s.client.blaze.PooledHttp1Client()
  val seed = new java.security.SecureRandom().nextLong
  val clock = Clock.systemUTC()

  def oauth2(callback: Uri, clientId: String, clientSecret: String, scope: String): OAuth2 = OAuth2(client,
    OAuth2Settings(
      Uri.uri("https://login.eveonline.com/oauth/authorize"),
      Uri.uri("https://login.eveonline.com/oauth/token"),
      callback,
      Uri.uri("https://login.eveonline.com/oauth/verify"),
      clientId,
      clientSecret,
      Uri.uri("https://login.eveonline.com/oauth/token"),
      Some(scope)
    ), OAuth2State(seed), clock, OAuth2ClientSettings("login"))

  // Thanks to @rossabaker
  def genToken(implicit oauth: OAuth2): Task[OAuth2Token] =
    Task.async[OAuth2Token]({ k =>
      val latch = new CountDownLatch(1)
      val service = oauth.oauthService({
        token => k(\/-(token)); Ok("Done.").map({x =>latch.countDown(); x})
      })
      val port = oauth.settings.callbackUri.port.getOrElse(80)
      val server: Server = BlazeBuilder.mountService(Kleisli(service).local({x => println(x); x})).bindHttp(port, "localhost").run
      println(s"Go to http://localhost:${port}/login")
      latch.await()
      server.shutdown.unsafePerformSync
    })
}
