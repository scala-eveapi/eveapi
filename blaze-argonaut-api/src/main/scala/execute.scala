package eveapi

import argonaut.{CursorHistory, Parse}
import org.atnos.eff.StateEffect
import scalaz._, Scalaz._
import scalaz.concurrent._
import org.http4s._
import org.http4s.argonaut._
import scala.xml.XML

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
      case Lift.GetXML(link, dec) =>
        fetchXML(link.href)(dec)
    }
  }

  /*
   **
   * A simple decoder, mostly for testing purposes. Pass in a href => result.
   */
  def localInterpreter(values: Uri => String) =
    new (Lift.Link ~> Either[Either[String, (String, CursorHistory)], ?]) {
      def apply[T](l: Lift.Link[T]) = l match {
        case Lift.Get(link, dec) => Parse.decode(values(link.href))(dec)
        case Lift.Put(link, _, dec, _) => Parse.decode(values(link.href))(dec)
        case Lift.Post(link, _, dec, _) => Parse.decode(values(link.href))(dec)
        case Lift.Delete(link, dec) => Parse.decode(values(link.href))(dec)
        case Lift.GetXML(link, dec) =>
          Right(scalaxb.fromXML[T](XML.loadString(values(link.href)))(dec))
      }
    }
}
