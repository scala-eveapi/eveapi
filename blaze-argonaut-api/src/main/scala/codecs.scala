package eveapi.utils

import argonaut._
import org.http4s.Uri

object Decoders {
  implicit val urlcodec: CodecJson[Uri] = CodecJson(
      (uri: Uri) => Json.jString(uri.toString),
      c =>
        c.as[String]
          .flatMap(str =>
                Uri
                  .fromString(str)
                  .fold(err => DecodeResult.fail(err.toString, c.history),
                        uri => DecodeResult.ok(uri)))
  )
}
