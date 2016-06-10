package eveapi.data.crest

case class Position(
  y: Double,
  x: Double,
  z: Double
)

case class Constellation()
case class Station()

case class SolarSystem(
  stats: Href,
  name: String,
  securityStatus: Double,
  securityClass: String,
  href: String,
  planets: List[Href],
  position: Position,
  constellation: ShortIdentifier[Constellation],
  id: Long
)
