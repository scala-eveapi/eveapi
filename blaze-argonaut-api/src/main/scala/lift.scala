package eveapi
import scalaz._, Scalaz._
import eveapi.data.crest._
import argonaut._
import org.http4s._

object Lift {
  sealed abstract class Link[T] extends Serializable with Product {
    def decoder: DecodeJson[T]
  }
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

  def get[T](l: GetLink[Uri, T])(implicit dec: DecodeJson[T]) = Free.liftF(Get(l, dec))
  def put[T](l: PutLink[Uri, T], value: T)(
    implicit dec: DecodeJson[UpdateResponse], enc: EncodeJson[T]) =
    Free.liftF(Put(l, value, dec, enc))
  def post[T](l: PostLink[Uri, T], value: T)(
    implicit dec: DecodeJson[CreationResponse], enc: EncodeJson[T]) =
    Free.liftF(Post(l, value, dec, enc))
  def delete(l: DeleteLink[Uri])(implicit dec: DecodeJson[DeletionResponse]) =
    Free.liftF(Delete(l, dec))
}
