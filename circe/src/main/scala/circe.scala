package eveapi.circeCodecs

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

import eveapi.data.crest._

object codecs {
  implicit def inviteEncode[L: Encoder]: Encoder[InviteMember[L]] = Encoder.instance { inv =>
    Json.obj(
        "role" -> inv.role.asJson,
        "wingID" -> inv.wingID.asJson,
        "squadID" -> inv.squadID.asJson,
        "character" -> inv.character.asJson
    )
  }

  // implicit def fcinvite[L: Encoder]: Encoder[InviteMember.FleetCommander[L]] =
  //   inviteEncode.contramap(x => x)
}
