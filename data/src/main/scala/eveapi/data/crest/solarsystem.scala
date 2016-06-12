package eveapi.data.crest

case class Position(
  y: Double,
  x: Double,
  z: Double
)

case class Constellation[L]()
case class Station[L]()

case class SolarSystem[L](
  // stats: Href,
  name: String,
  securityStatus: Double,
  securityClass: String,
  href: String,
  // planets: List[Href],
  position: Position,
  constellation: ShortIdentifier[L, Constellation],
  id: Long
)
