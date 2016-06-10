package eveapi.data.zkillboard

case class Victim(
  x: Double,
  y: Double,
  z: Double,
  shipTypeID: Long,
  characterID: Long,
  characterName: String,
  corporationID: Long,
  corporationName: String,
  allianceID: Long,
  allianceName: String,
  factionID: Long,
  factionName: String,
  damageTaken: Long
)

case class Attackers(
  characterID: Long,
  characterName: String,
  corporationID: Long,
  corporationName: String,
  allianceID: Long,
  allianceName: String,
  factionID: Long,
  factionName: String,
  securityStatus: Long,
  damageDone: Double,
  finalBlow: Long,
  weaponTypeID: Long,
  shipTypeID: Long
)

case class Items(
  typeID: Long,
  flag: Long,
  qtyDropped: Long,
  qtyDestroyed: Long,
  singleton: Long
)

case class Killmail(
  killID: Long,
  solarSystemID: Long,
  killTime: String,
  moonID: Long,
  victim: Victim,
  attackers: List[Attackers],
  items: List[Items]
)

case class SolarSystem(
  href: String,
  id: Long,
  name: String
)

case class Icon(
  href: String
)

case class Href(
  href: String,
  id: Long,
  name: String,
  icon: Icon
)

case class Position(
  y: Double,
  x: Double,
  z: Double
)

case class War(
  href: String,
  id: Long
)

case class Zkb(
  locationID: Long,
  hash: String,
  totalValue: Double,
  points: Long,
  href: String
)

case class Package(
  killID: Long,
  killmail: Killmail,
  zkb: Zkb
)

case class RedisQResponse(
  `package`: Option[Package]
)
