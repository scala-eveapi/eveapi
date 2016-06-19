package eveapi.data.crest

import java.time._

case class FleetUrl[L](href: L) extends GetLink[L, Fleet[L]] with PutLink[L, FleetUpdate]
case class FleetUpdate(isFreeMove: Option[Boolean] = None, motd: Option[String] = None)

// TODO write circe/argonaut codecs for this one
sealed abstract class InviteMember[L] extends Serializable with Product {
  def role: String
  def wingID: Option[Long]
  def squadID: Option[Long]
  def character: GetLinkI[L, Character[L]]
}
object InviteMember {
  case class FleetCommander[L](character: GetLinkI[L, Character[L]]) extends InviteMember[L] {
    def role = "fleetCommander"
    val wingID = None
    val squadID = None
  }
  case class WingCommander[L](character: GetLinkI[L, Character[L]], wingId: Long)
      extends InviteMember[L] {
    def role = "wingCommander"
    val wingID = Some(wingId)
    val squadID = None
  }
  case class SquadCommander[L](character: GetLinkI[L, Character[L]], wingId: Long, squadId: Long)
      extends InviteMember[L] {
    def role = "squadCommander"
    val wingID = Some(wingId)
    val squadID = Some(squadId)
  }
  case class SquadMember[L](character: GetLinkI[L, Character[L]], wingId: Long, squadId: Long)
      extends InviteMember[L] {
    def role = "squadMember"
    val wingID = Some(wingId)
    val squadID = Some(squadId)
  }
  case class RandomInvite[L](character: GetLinkI[L, Character[L]]) extends InviteMember[L] {
    def role = "squadMember"
    val wingID = None
    val squadID = None
  }
}

case class Fleet[L](
  isFreeMove: Boolean,
  isRegistered: Boolean,
  isVoiceEnabled: Boolean,
  motd: String,
  wings: GetLinkI[L, Paginated[Wing[L]]],
  members: GetPostLink[L, Paginated[Member[L]], InviteMember[L]]
)

/**
  * Choose one of: squadMember, squadCommander, wingCommander, fleetCommander
  */
case class MoveMember[L](
  role: String = "squadMember", newWingId: Option[Long], squadID: Option[Long])

case class Member[L](
  boosterID: Short,
  character: Identifier[L, Character],
  joinTime: Instant,
  roleID: Short,
  ship: Identifier[L, Ship],
  solarSystem: Identifier[L, SolarSystem],
  squadID: Long,
  station: Option[Identifier[L, Station]],
  takesFleetWarp: Boolean,
  wingID: Long,
  href: L
)
    extends PutLink[L, MoveMember[L]]
    with DeleteLink[L]

case class Wing[L](
  id: Long,
  name: String,
  squadsList: List[Squad[L]],
  squads: PostLinkI[L, Empty],
  href: L
)
    extends PutLink[L, Name]
    with DeleteLink[L]

case class Name(name: String)

case class Squad[L](
  id: Long,
  name: String,
  href: L
)
    extends PutLink[L, Name]
    with DeleteLink[L]

case class Ship[L]()
