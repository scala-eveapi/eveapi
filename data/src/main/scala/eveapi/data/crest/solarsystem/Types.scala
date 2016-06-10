package eveapi.data.crest.solarsystem

case class Href(
    href: String
)

case class Position(
    y: Double,
    x: Double,
    z: Double
)

case class Constellation(
    href: String,
    id: Long,
    id_str: String
)

case class SolarSystem(
    stats: Href,
    name: String,
    securityStatus: Double,
    securityClass: String,
    href: String,
    id_str: String,
    planets: List[Href],
    position: Position,
    constellation: Constellation,
    id: Long
)
