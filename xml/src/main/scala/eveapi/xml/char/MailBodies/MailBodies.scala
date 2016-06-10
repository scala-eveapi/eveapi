// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.MailBodies

case class Eveapi(currentTime: String,
                  result: eveapi.xml.char.MailBodies.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.char.MailBodies.Rowset)

case class Rowset(row: eveapi.xml.char.MailBodies.Row,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
               attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val messageID = attributes("@messageID").as[BigInt]
}
