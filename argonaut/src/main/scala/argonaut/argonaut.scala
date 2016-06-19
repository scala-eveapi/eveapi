package eveapi.argonautCodecs

import eveapi.data.crest._
import argonaut._, Argonaut._, Shapeless._

object codecs {
  def inviteEncode[L: EncodeJson]: EncodeJson[InviteMember[L]] = EncodeJson { inv =>
    ("role" := inv.role) ->:
    ("wingID" := inv.wingID) ->:
    ("squadID" := inv.squadID) ->:
    ("character" := inv.character) ->: jEmptyObject
  }
}
