package eveapi.data.crest.contacts

case class Href(
    href: String
)

case class Alliance(
    id_str: String,
    href: String,
    id: Double,
    name: String
)

case class Corporation(
    name: String,
    isNPC: Boolean,
    href: String,
    id_str: String,
    logo: Map[String, Href],
    id: Long
)

case class Character(
    name: String,
    corporation: Corporation,
    isNPC: Boolean,
    href: String,
    capsuleer: Href,
    portrait: Map[String, Href],
    id: Long,
    id_str: String
)

case class Contact(
    id_str: String,
    href: String,
    name: String,
    id: Long
)

case class Items(
    standing: Double,
    character: Option[Character],
    alliance: Option[Alliance],
    corporation: Option[Corporation],
    contact: Contact,
    href: String,
    contactType: String,
    watched: Boolean,
    blocked: Boolean
)

case class ContactList(
    totalCount_str: String,
    items: List[Items],
    pageCount: Long,
    pageCount_str: String,
    totalCount: Long
)

case class ContactCreateInner(
    id_str: String,
    href: String,
    name: String,
    id: Long
)

case class ContactCreate(
    standing: Int,
    contactType: String,
    contact: ContactCreateInner,
    watched: Boolean
)
