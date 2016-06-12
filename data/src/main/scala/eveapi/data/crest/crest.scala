package eveapi.data.crest

case class Href(
  href: String
)

case class ImageHref(
  href: String
)

trait Identifier[L, T[_]] extends GetLink[L, T[L]] {
  def id: Long
  def href: L
}

case class ShortIdentifier[L, T[_]](
  id: Long,
  href: L
)
    extends Identifier[L, T]

case class StandardIdentifier[L, T[_]](
  id: Long,
  name: String,
  href: L
)
    extends Identifier[L, T]

case class ContactIdentifier[L, T[_]](
  id: Long,
  name: String,
  href: L,
  isNPC: Boolean
)
    extends Identifier[L, T]

case class Paginated[T](
  items: List[T],
  pageCount: Long,
  totalCount: Long
)

case class Empty()
