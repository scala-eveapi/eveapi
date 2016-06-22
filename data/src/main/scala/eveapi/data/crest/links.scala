package eveapi.data.crest

// TODO add more
sealed trait EveException {
  def exceptionType: String
  def key: String
}
case class ForbiddenError(
  exceptionType: String,
  isLocalized: Boolean,
  key: String,
  message: String,
  title: Option[String]
)
    extends EveException
case class UnsupportedMediaTypeError(
  exceptionType: String,
  key: String,
  message: String
)
    extends EveException

sealed trait Response {
  def code: Int
  def error: Option[EveException]
}
case class CreationResponse(code: Int, error: Option[EveException]) extends Response
case class UpdateResponse(code: Int, error: Option[EveException]) extends Response
case class DeletionResponse(code: Int, error: Option[EveException]) extends Response

// Case classes
sealed trait Link[L] { def href: L }
trait GetLink[L, T] extends Link[L]
trait PutLink[L, T] extends Link[L]
trait PostLink[L, T] extends Link[L]
trait DeleteLink[L] extends Link[L]

case class GetLinkI[L, T](href: L) extends GetLink[L, T]
case class PutLinkI[L, T](href: L) extends PutLink[L, T]
case class PostLinkI[L, T](href: L) extends PostLink[L, T]
case class DeleteLinkI[L](href: L) extends DeleteLink[L]

case class GetPutLink[L, Get, Put](href: L) extends GetLink[L, Get] with PutLink[L, Put]
case class GetPostLink[L, Get, Post](href: L) extends GetLink[L, Get] with PostLink[L, Post]
case class GetDeleteLink[L, Get](href: L) extends GetLink[L, Get] with DeleteLink[L]
case class PutPostLink[L, Put, Post](href: L) extends PutLink[L, Put] with PostLink[L, Post]
case class PutDeleteLink[L, Put](href: L) extends PutLink[L, Put] with DeleteLink[L]
case class PostDeleteLink[L, Post](href: L) extends PostLink[L, Post] with DeleteLink[L]

// TODO add more as needed
