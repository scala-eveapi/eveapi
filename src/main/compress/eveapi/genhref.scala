package eveapi.compress

import scalaz._, Scalaz._
import org.http4s._
import eveapi.compressed.Identifier

trait GenHref[T] {
  def href(id: Identifier[T]): Reader[EveServer, Uri]
}

object GenHref {
  def serverHref(path: String) = Reader {s: EveServer => Uri(Some(CaseInsensitiveString("https")), Some(Uri.Authority(host = s.server)), path=path)}
  implicit val ship = new GenHref[Ship] {
    def href(id: Identifier[Ship]) = serverHref( s"/types/${id.id}/")
  }
  implicit val solarsystem = new GenHref[SolarSystem] {
    def href(id: Identifier[SolarSystem]) = serverHref(s"/solarsystems/${id.id}/")
  }
  implicit val station = new GenHref[Station] {
    def href(id: Identifier[Station]) = serverHref(s"/stations/${id.id}/")
  }
  implicit val character = new GenHref[Character] {
    def href(id: Identifier[Character]) = serverHref(s"/characters/${id.id}/")
  }

  def members(fleet: Fleet): Api[Paginated[Member]] =
      fetch[Paginated[Member]](serverHref(s"/fleets/${fleet.id}/members/"))
  def wings(fleet: Fleet): Api[Paginated[Wing]] =
    fetch[Paginated[Wing]](serverHref(s"/fleets/${fleet.id}/wings/"))

  def member(member: Member): Reader[(EveServer, Fleet), Uri] = Reader { case (s, f) =>
    serverHref(s"/fleets/${f.id}/members/${member.character.id}/").run(s)
  }
  def squads(wing: Wing): Reader[(EveServer, Fleet), Uri] = Reader { case (s, f) =>
    serverHref(s"/fleets/${f.id}/wings/${wing.id}/").run(s)
  }
  def squad(squad: Squad): Reader[(EveServer, Fleet, Wing), Uri] = Reader { case (s, f, w) =>
    serverHref(s"/fleets/${f.id}/wings/${w.id}/squads/${squad.id}/").run(s)
  }
}
