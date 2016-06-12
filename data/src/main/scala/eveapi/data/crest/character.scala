package eveapi.data.crest

case class Portrait(
  `32x32`: ImageHref,
  `64x64`: ImageHref,
  `128x128`: ImageHref,
  `256x256`: ImageHref
)

case class Corporation(
  name: String,
  isNPC: Boolean,
  href: String,
  logo: Portrait,
  id: Long
)

case class BloodLine[L]()
case class Race[L]()

case class Character[L](
  // standings: GetLinkI[L],
  bloodLine: Identifier[L, BloodLine],
  // waypoints: Href,
  // channels: Href,
  href: GetLinkI[L, Character[L]],
  // accounts: Href,
  portrait: Portrait,
  id: Long,
  // fittings: Href,
  // contacts: Href,
  corporation: Corporation,
  // location: Href,
  // mail: Href,
  description: String,
  // notifications: Href,
  name: String,
  gender: Long,
  race: Identifier[L, Race]
)

case class Location[L](
  solarSystem: Option[Identifier[L, SolarSystem]],
  station: Option[Identifier[L, Station]]
)

case class Alliance[L]()

case class ContactsCharacter(
  name: String,
  corporation: Corporation,
  isNPC: Boolean,
  href: String,
  // capsuleer: Href,
  portrait: Map[String, ImageHref],
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

case class AllianceContact[L](
  standing: Double,
  alliance: Identifier[L, Alliance],
  contact: Contact,
  href: String,
  contactType: String,
  watched: Boolean,
  blocked: Boolean
)
    extends ContactsListItem

case class CharacterContact(
  standing: Double,
  character: ContactsCharacter,
  contact: Contact,
  href: String,
  contactType: String,
  watched: Boolean,
  blocked: Boolean
)
    extends ContactsListItem

case class CorporationContact(
  standing: Double,
  corporation: Corporation,
  contact: Contact,
  href: String,
  contactType: String,
  watched: Boolean,
  blocked: Boolean
)
    extends ContactsListItem

case class ContactCreate(
  standing: Int,
  contactType: String,
  contact: Contact,
  watched: Boolean
)
