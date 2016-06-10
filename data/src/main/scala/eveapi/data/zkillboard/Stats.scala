package eveapi.data.zkillboard

object Stats {

  case class Group(
    groupID: Long,
    shipsLost: Option[Long],
    pointsLost: Option[Long],
    iskLost: Option[Double],
    shipsDestroyed: Long,
    pointsDestroyed: Long,
    iskDestroyed: Double
  )

  case class Month(
    year: Long,
    month: Long,
    shipsLost: Long,
    pointsLost: Long,
    iskLost: Double,
    shipsDestroyed: Long,
    pointsDestroyed: Long,
    iskDestroyed: Double
  )

  case class SuperPilot(
    kills: Long,
    characterID: Long,
    characterName: String
  )

  case class Characters(
    `type`: String,
    count: Long
  )

  case class Activepvp(
    characters: Characters,
    corporations: Characters,
    ships: Characters,
    systems: Characters,
    regions: Characters,
    kills: Characters
  )

  case class LastApiUpdate(
    sec: Double,
    usec: Double
  )

  case class AlliInfo(
    corpCount: Long,
    deleted: Boolean,
    executorCorpID: Long,
    factionID: Long,
    id: Long,
    killID: Long,
    lastApiUpdate: LastApiUpdate,
    memberCount: Long,
    name: String,
    ticker: String,
    `type`: String
  )

  case class CorpInfo(
    allianceID: Long,
    ceoID: Long,
    factionID: Long,
    id: Long,
    killID: Long,
    lastApiUpdate: LastApiUpdate,
    memberCount: Long,
    name: String,
    ticker: String,
    `type`: String
  )

  case class SuperPilots(
    data: List[SuperPilot],
    title: String
  )

  case class Supers(
    titans: SuperPilots,
    supercarriers: SuperPilots
  )

  case class AllianceInfo(
    allTimeSum: Double,
    groups: Map[Long, Group],
    id: Long,
    iskDestroyed: Double,
    iskLost: Double,
    months: Map[Long, Month],
    pointsDestroyed: Long,
    pointsLost: Long,
    sequence: Double,
    shipsDestroyed: Long,
    shipsLost: Long,
    `type`: String,
    info: AlliInfo,
    supers: Supers,
    hasSupers: Boolean
  ) {
    def getSupers: List[SuperPilot] =
      List(Option(supers.supercarriers.data)).flatten.flatten

    def getTitans: List[SuperPilot] =
      List(Option(supers.titans.data)).flatten.flatten
  }

  case class CorporationInfo(
    allTimeSum: Double,
    groups: Map[Long, Group],
    id: Long,
    iskDestroyed: Double,
    iskLost: Double,
    months: Map[Long, Month],
    pointsDestroyed: Long,
    pointsLost: Long,
    sequence: Double,
    shipsDestroyed: Long,
    shipsLost: Long,
    `type`: String,
    info: CorpInfo,
    supers: Supers,
    hasSupers: Boolean
  ) {
    def getSupers: List[SuperPilot] =
      List(Option(supers.supercarriers.data)).flatten.flatten

    def getTitans: List[SuperPilot] =
      List(Option(supers.titans.data)).flatten.flatten
  }
}
