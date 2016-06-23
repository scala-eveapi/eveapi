package eveapi.blazeClient

import scalaz._, Scalaz._
import scalaz.concurrent._
import org.http4s._
import org.http4s.argonaut._

import eveapi.execute._
import eveapi.oauth._
import eveapi.utils.TaskEffect._

object Execute {
  import OAuth2._
  def OAuthInterpreter(oauth: OAuth2) = new (Lift.Link ~> Api) {
    def apply[T](l: Lift.Link[T]) = l match {
      case Lift.Get(link, dec) => oauth.fetch(Request(uri = link.href, method = Method.GET))(dec)
      case Lift.Put(link, value, dec, enc) =>
        oauth.fetch(Request(uri = link.href, method = Method.PUT).withBody(enc.encode(value)))(dec)
      case Lift.Post(link, value, dec, enc) =>
        oauth
          .fetch(Request(uri = link.href, method = Method.POST).withBody(enc.encode(value)))(dec)
      case Lift.Delete(link, dec) =>
        oauth.fetch(Request(uri = link.href, method = Method.DELETE))(dec)
    }
  }
}
