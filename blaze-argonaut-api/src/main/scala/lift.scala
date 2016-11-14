package eveapi
import scalaz._, Scalaz._
import eveapi.data.crest._
import argonaut._
import org.http4s._

object Lift {
  sealed abstract class Link[T] extends Serializable with Product
  case class Get[T](link: GetLink[Uri, T], decoder: DecodeJson[T]) extends Link[T]
  case class Put[T](
    link: PutLink[Uri, T], value: T, decoder: DecodeJson[UpdateResponse], encoder: EncodeJson[T])
      extends Link[UpdateResponse]
  case class Post[T](link: PostLink[Uri, T],
                     value: T,
                     decoder: DecodeJson[CreationResponse],
                     encoder: EncodeJson[T])
      extends Link[CreationResponse]
  case class Delete(link: DeleteLink[Uri], decoder: DecodeJson[DeletionResponse])
      extends Link[DeletionResponse]
  case class GetXML[T](link: XMLLink[T], decoder: scalaxb.XMLFormat[T]) extends Link[T]

  def get[T](l: GetLink[Uri, T])(implicit dec: DecodeJson[T]) = Free.liftF[Link, T](Get(l, dec))
  def put[T](l: PutLink[Uri, T], value: T)(
    implicit dec: DecodeJson[UpdateResponse], enc: EncodeJson[T]) =
    Free.liftF[Link, UpdateResponse](Put(l, value, dec, enc))
  def post[T](l: PostLink[Uri, T], value: T)(
    implicit dec: DecodeJson[CreationResponse], enc: EncodeJson[T]) =
    Free.liftF[Link, CreationResponse](Post(l, value, dec, enc))
  def delete(l: DeleteLink[Uri])(implicit dec: DecodeJson[DeletionResponse]) =
    Free.liftF[Link, DeletionResponse](Delete(l, dec))
  def get[T](l: XMLLink[T])(implicit dec: scalaxb.XMLFormat[T]) =
    Free.liftF[Link, T](GetXML(l, dec))
}
