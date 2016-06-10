package eveapi.data.crest

case class Href(
    href: String
)

trait Identifier[T] {
  def id: Long
  def href: String
}

case class ShortIdentifier[T](
    id: Long,
    href: String
)
    extends Identifier[T]

case class StandardIdentifier[T](
    id: Long,
    name: String,
    href: String
)
    extends Identifier[T]

case class ContactIdentifier[T](
    id: Long,
    name: String,
    href: String,
    isNPC: Boolean
)
    extends Identifier[T]

case class Paginated[T](
    items: List[T],
    pageCount: Long,
    totalCount: Long
)
