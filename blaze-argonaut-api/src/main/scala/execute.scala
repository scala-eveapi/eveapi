package eveapi

import scalaz._, Scalaz._
import scalaz.concurrent._
import org.http4s._
import org.http4s.argonaut._

import eveapi.oauth._
import eveapi.utils.TaskEffect._

object Execute {
  import OAuth2._
  val OAuthInterpreter = new (Lift.Link ~> Api) {
    def apply[T](l: Lift.Link[T]) = l match {
      case Lift.Get(link, dec) => fetch(Request(uri = link.href, method = Method.GET))(dec)
      case Lift.Put(link, value, dec, enc) =>
        fetch(Request(uri = link.href, method = Method.PUT).withBody(enc.encode(value)))(dec)
      case Lift.Post(link, value, dec, enc) =>
        fetch(Request(uri = link.href, method = Method.POST).withBody(enc.encode(value)))(dec)
      case Lift.Delete(link, dec) =>
        fetch(Request(uri = link.href, method = Method.DELETE))(dec)
    }
  }
}
