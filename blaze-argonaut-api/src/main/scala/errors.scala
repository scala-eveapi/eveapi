package eveapi.errors

import argonaut.CursorHistory
import org.http4s._, org.http4s.dsl._, org.http4s.client._
import scalaz._, Scalaz._

sealed trait EveApiError extends Throwable

case class StateNotFound(got: String, states: Set[String]) extends EveApiError {
  override def getMessage = s"Got $got, expected $states"
}
case class ParseError(message: String) extends EveApiError {
  override def getMessage = message
}
case class JsonParseError(message: String \/ (String, CursorHistory)) extends EveApiError {
  override def getMessage = message.toString
}
case class ParseFailure(fail: org.http4s.ParseFailure) extends EveApiError {
  override def getMessage = fail.toString
}
case class EveApiStatusFailed(fail: Status, body: String) extends EveApiError {
  override def getMessage = s"Failed with: $fail Message: $body"
}
case class ThrownException(exception: Throwable) extends EveApiError {
  override def getCause = exception
}
