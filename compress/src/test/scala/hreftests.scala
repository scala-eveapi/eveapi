import eveapi.compress._

import scalaz._, Scalaz._
import java.time._

import eveapi.data.crest._

import org.scalacheck._
import Arbitrary.arbitrary
import org.scalacheck.Prop._
import org.scalacheck.Shapeless._

case class Url(server: String, path: String)

object CompressSpecification extends Properties("Compress") {
  implicit val lens = new PathLens[Url] {
    def toLink(path: String) = Reader { server =>
      Url(server.server, path)
    }
    def fromLink(l: Url) = l.path
  }

  implicit val instant: Arbitrary[Instant] = Arbitrary(
      arbitrary[Long].map(l => Instant.ofEpochMilli(l)))

  val compress = Compress[Url]
  import compress._

  implicit val positiveLong: Arbitrary[Long] = Arbitrary(Gen.choose(0, Long.MaxValue))

  def genShort[T[_]]()(implicit gen: GenHref[Url, T]) =
    for {
      id <- arbitrary[Long]
    } yield GenHref.identifier[Url, T](id).run(EveServer("test"))

  property("ship") = forAll(genShort[Ship]) { ship: ShortIdentifier[Url, Ship] =>
    decompress[ShortIdentifier[?, Ship], CompressedShortIdentifier[Ship]](
        compress.compress[ShortIdentifier[?, Ship], CompressedShortIdentifier[Ship]](ship))
      .run(EveServer("test")) == ship
  }
  property("solarsystem") = forAll(genShort[SolarSystem]) {
    solarsystem: ShortIdentifier[Url, SolarSystem] =>
      decompress[ShortIdentifier[?, SolarSystem], CompressedShortIdentifier[SolarSystem]](compress
            .compress[ShortIdentifier[?, SolarSystem], CompressedShortIdentifier[SolarSystem]](
              solarsystem)).run(EveServer("test")) == solarsystem
  }
  property("Character") = forAll(genShort[Character]) {
    Character: ShortIdentifier[Url, Character] =>
      decompress[ShortIdentifier[?, Character], CompressedShortIdentifier[Character]](
          compress.compress[ShortIdentifier[?, Character], CompressedShortIdentifier[Character]](
              Character)).run(EveServer("test")) == Character
  }
  property("station") = forAll(genShort[Station]) { station: ShortIdentifier[Url, Station] =>
    decompress[ShortIdentifier[?, Station], CompressedShortIdentifier[Station]](
        compress.compress[ShortIdentifier[?, Station], CompressedShortIdentifier[Station]](
            station)).run(EveServer("test")) == station
  }
  property("squad") = forAll { compressed: CompressedSquad =>
    compress.compress(decompress(compressed).run(EveServer("test"))) == compressed
  }
  property("wing") = forAll { compressed: CompressedWing =>
    compress.compress(decompress(compressed).run(EveServer("test"))) == compressed
  }
  property("fleet") = forAll { compressed: CompressedFleet =>
    compress.compress(decompress(compressed).run(EveServer("test"))) == compressed
  }
  property("member") = forAll { compressed: CompressedMember =>
    compress.compress(decompress(compressed).run(EveServer("test"))) == compressed
  }
}
