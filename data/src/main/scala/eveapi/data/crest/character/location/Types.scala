package eveapi.data.crest.character.location

case class SolarSystem(
    id_str: String,
    href: String,
    id: Long,
    name: String
)

case class Location(
    solarSystem: Option[SolarSystem],
    station: Option[Station]
)

case class Station(
    id_str: String,
    href: String,
    id: Long,
    name: String
)
