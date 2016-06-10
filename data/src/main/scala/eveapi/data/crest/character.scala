package eveapi.data.crest

case class Portrait(
    `32x32`: Href,
    `64x64`: Href,
    `128x128`: Href,
    `256x256`: Href
)

case class Corporation(
    name: String,
    isNPC: Boolean,
    href: String,
    logo: Portrait,
    id: Long
)

case class BloodLine()
case class Race()

case class Character(
    standings: Href,
    bloodLine: Identifier[BloodLine],
    waypoints: Href,
    channels: Href,
    href: String,
    accounts: Href,
    portrait: Portrait,
    id: Long,
    fittings: Href,
    contacts: Href,
    corporation: Corporation,
    location: Href,
    mail: Href,
    description: String,
    notifications: Href,
    name: String,
    gender: Long,
    race: Identifier[Race]
)

case class Location(
    solarSystem: Option[Identifier[SolarSystem]],
    station: Option[Identifier[Station]]
)

case class Alliance()

case class ContactsCharacter(
    name: String,
    corporation: Corporation,
    isNPC: Boolean,
    href: String,
    capsuleer: Href,
    portrait: Map[String, Href],
    id: Long
)

case class Contact(
    id_str: String,
    href: String,
    name: String,
    id: Long
)

sealed trait ContactsListItem {
  def standing: Double
  def contact: Contact
  def href: String
  def contactType: String
  def watched: Boolean
  def blocked: Boolean
}

case class Item(
    standing: Double,
    character: Option[ContactsCharacter],
    alliance: Option[Identifier[Alliance]],
    corporation: Option[Corporation],
    contact: Contact,
    href: String,
    contactType: String,
    watched: Boolean,
    blocked: Boolean
)

case class ContactCreate(
    standing: Int,
    contactType: String,
    contact: Contact,
    watched: Boolean
)
