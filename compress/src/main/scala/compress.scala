package eveapi.compress

import scalaz._, Scalaz._
import java.time._

import eveapi.data.crest._

case class Compress[L](implicit val lens: PathLens[L]) {
  trait CompressLink[T[_], IdType] {
    def compress(href: T[L]): IdType
    def decompress(id: IdType): Reader[EveServer, T[L]]
  }

  implicit def compressShortIdentifier[T[_]](implicit href: GenHref[L, T]) =
    new CompressLink[Lambda[Lin => ShortIdentifier[Lin, T]], CompressedShortIdentifier[T]] {
      def compress(id: ShortIdentifier[L, T]) =
        CompressedShortIdentifier(id.id)
      def decompress(id: CompressedShortIdentifier[T]) =
        href.href(id.id).map(href => ShortIdentifier(id.id, href))
    }

  implicit def compressStandardIdentifier[T[_]](implicit href: GenHref[L, T]) =
    new CompressLink[Lambda[Lin => StandardIdentifier[Lin, T]], CompressedStandardIdentifier[T]] {
      def compress(id: StandardIdentifier[L, T]) =
        CompressedStandardIdentifier(id.id, id.name)
      def decompress(id: CompressedStandardIdentifier[T]) =
        href.href(id.id).map(href => StandardIdentifier(id.id, id.name, href))
    }

  implicit def compressContactIdentifier[T[_]]()(implicit href: GenHref[L, T]) =
    new CompressLink[Lambda[Lin => ContactIdentifier[Lin, T]], CompressedContactIdentifier[T]] {
      def compress(id: ContactIdentifier[L, T]) =
        CompressedContactIdentifier(id.id, id.name, id.isNPC)
      def decompress(id: CompressedContactIdentifier[T]) =
        href.href(id.id).map(href => ContactIdentifier(id.id, id.name, href, id.isNPC))
    }
  implicit def compressSquad = new CompressLink[Squad, CompressedSquad] {
    def compress(id: Squad[L]) = {
      val Array("", "fleets", fleetId, "wings", wingId, "squads", squadId) =
        lens.fromLink(id.href).split("/")
      CompressedSquad(fleetId.toLong, wingId.toLong, squadId.toLong, id.name)
    }
    def decompress(id: CompressedSquad) = {
      lens
        .toLink(s"/fleets/${id.fleetId}/wings/${id.wingId}/squads/${id.squadId}/")
        .map(href => Squad(id.squadId, id.name, href))
    }
  }
  implicit def compressWing(implicit compressSquad: CompressLink[Squad, CompressedSquad]) =
    new CompressLink[Wing, CompressedWing] {
      def compress(id: Wing[L]) = {
        val Array("", "fleets", fleetId, "wings", wingId) = lens.fromLink(id.href).split("/")
        CompressedWing(
            fleetId.toLong, wingId.toLong, id.name, id.squadsList.map(compressSquad.compress))
      }
      def decompress(id: CompressedWing) = {
        for {
          squads <- lens.toLink(s"/fleets/${id.fleetId}/wings/${id.wingId}/squads/")
          href <- lens.toLink(s"/fleets/${id.fleetId}/wings/${id.wingId}/")
          squadsList <- id.squadsList
                         .map(compressSquad.decompress)
                         .sequence[Reader[EveServer, ?], Squad[L]]
        } yield {
          Wing(id.wingId, id.name, squadsList, PostLinkI(squads), href)
        }
      }
    }
  implicit def compressMember(
    implicit compressCharacter: CompressLink[
        Lambda[Lin => StandardIdentifier[Lin, Character]], CompressedCharacter],
    compressShip: CompressLink[Lambda[Lin => StandardIdentifier[Lin, Ship]], CompressedShip],
    compressSolarSystem: CompressLink[Lambda[Lin => StandardIdentifier[Lin, SolarSystem]],
                                      CompressedStandardIdentifier[SolarSystem]],
    compressStation: CompressLink[
        Lambda[Lin => StandardIdentifier[Lin, Station]], CompressedStandardIdentifier[Station]]) =
    new CompressLink[Member, CompressedMember] {
      def compress(member: Member[L]) = {
        val Array("", "fleets", fleetId, "members", characterId) =
          lens.fromLink(member.href).split("/")
        CompressedMember(fleetId.toLong,
                         member.boosterID,
                         compressCharacter.compress(member.character),
                         member.joinTime,
                         member.roleID,
                         compressShip.compress(member.ship),
                         compressSolarSystem.compress(member.solarSystem),
                         member.squadID,
                         member.station.map(compressStation.compress),
                         member.takesFleetWarp,
                         member.wingID)
      }
      def decompress(id: CompressedMember) = {
        for {
          character <- compressCharacter.decompress(id.character)
          ship <- compressShip.decompress(id.ship)
          solarSystem <- compressSolarSystem.decompress(id.solarSystem)
          station <- id.station
                      .map(compressStation.decompress)
                      .sequence[Reader[EveServer, ?], StandardIdentifier[L, Station]]
          href <- lens.toLink(s"/fleets/${id.fleetId}/members/${character.id}/")
        } yield {
          Member(id.boosterID,
                 character,
                 id.joinTime,
                 id.roleID,
                 ship,
                 solarSystem,
                 id.squadID,
                 station,
                 id.takesFleetWarp,
                 id.wingID,
                 href)
        }
      }
    }
  implicit def compressFleet(implicit compressMember: CompressLink[Member, CompressedMember],
                             compressWing: CompressLink[Wing, CompressedWing]) =
    new CompressLink[Fleet, CompressedFleet] {
      def compress(fleet: Fleet[L]) = {
        val Array("", "fleets", fleetId, "members") = lens.fromLink(fleet.members.href).split("/")
        CompressedFleet(
            fleetId.toLong, fleet.isFreeMove, fleet.isRegistered, fleet.isVoiceEnabled, fleet.motd)
      }
      def decompress(id: CompressedFleet) = {
        for {
          members <- lens.toLink(s"/fleets/${id.fleetId}/members/")
          wings <- lens.toLink(s"/fleets/${id.fleetId}/wings/")
        } yield {
          Fleet(id.isFreeMove,
                id.isRegistered,
                id.isVoiceEnabled,
                id.motd,
                GetLinkI(wings),
                GetPostLink(members))
        }
      }
    }

  def compress[T[_], IdType](t: T[L])(implicit compress: CompressLink[T, IdType]): IdType = {
    compress.compress(t)
  }
  def decompress[T[_], IdType](t: IdType)(
    implicit compress: CompressLink[T, IdType]): Reader[EveServer, T[L]] =
    compress.decompress(t)
}

case class CompressedShortIdentifier[T[_]](id: Long)
case class CompressedStandardIdentifier[T[_]](id: Long, name: String)
case class CompressedContactIdentifier[T[_]](id: Long, name: String, isNPC: Boolean)

case class CompressedSquad(fleetId: Long, wingId: Long, squadId: Long, name: String)
case class CompressedWing(
  fleetId: Long, wingId: Long, name: String, squadsList: List[CompressedSquad])
case class CompressedMember(fleetId: Long,
                            boosterID: Short,
                            character: CompressedCharacter,
                            joinTime: Instant,
                            roleID: Short,
                            ship: CompressedShip,
                            solarSystem: CompressedSolarSystem,
                            squadID: Long,
                            station: Option[CompressedStation],
                            takesFleetWarp: Boolean,
                            wingID: Long)
case class CompressedFleet(
  fleetId: Long, isFreeMove: Boolean, isRegistered: Boolean, isVoiceEnabled: Boolean, motd: String)
case class CompressedLocation(
  solarSystem: Option[CompressedSolarSystem], station: Option[CompressedStation])

case class EveServer(server: String)

trait PathLens[L] {
  def toLink(path: String): Reader[EveServer, L]
  def fromLink(l: L): String
}

trait GenHref[L, T[_]] {
  def href(id: Long)(implicit lens: PathLens[L]): Reader[EveServer, L]
}

object GenHref {
  implicit def ship[L] = new GenHref[L, Ship] {
    def href(id: Long)(implicit lens: PathLens[L]) = lens.toLink(s"/types/${id}/")
  }
  implicit def solarsystem[L] = new GenHref[L, SolarSystem] {
    def href(id: Long)(implicit lens: PathLens[L]) = lens.toLink(s"/solarsystems/${id}/")
  }
  implicit def station[L] = new GenHref[L, Station] {
    def href(id: Long)(implicit lens: PathLens[L]) = lens.toLink(s"/stations/${id}/")
  }
  implicit def character[L] = new GenHref[L, Character] {
    def href(id: Long)(implicit lens: PathLens[L]) = lens.toLink(s"/characters/${id}/")
  }

  def identifier[L, T[_]](id: Long)(
    implicit gen: GenHref[L, T], lens: PathLens[L]): Reader[EveServer, ShortIdentifier[L, T]] =
    gen.href(id).map(href => ShortIdentifier[L, T](id, href))
}
