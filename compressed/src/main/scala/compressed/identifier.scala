package eveapi.compressed

import java.time._

// Even solar systems (8k in count) aren't paginated. Not implemeting for now.
case class Paginated[T](items: List[T], pageCount: Int, totalCount: Int)

case class Identifier[T](id: Long, name: String)

case class Fleet(
    id: Long,
    isFreeMove: Boolean,
    isRegistered: Boolean,
    isVoiceEnabled: Boolean,
    motd: String
)

case class Member(
    boosterID: Short,
    character: Identifier[Character],
    joinTime: String,
    roleID: Short,
    ship: Identifier[Ship],
    solarSystem: Identifier[SolarSystem],
    squadID: Long,
    station: Option[Identifier[Station]],
    takesFleetWarp: Boolean,
    wingID: Long
)

case class Wing(
    id: Long,
    name: String,
    squadsList: List[Squad]
)

case class Squad(
    id: Long,
    name: String
)

case class Character()

case class SolarSystem()

case class Station()

case class Ship()
