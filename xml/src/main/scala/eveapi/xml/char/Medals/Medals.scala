// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.char.Medals

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.char.Medals.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.account.char.Medals.Rowset*)

case class Rowset(row: Seq[eveapi.xml.account.char.Medals.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val corporationID = attributes.get("@corporationID") map { _.as[BigInt] }
  lazy val description = attributes.get("@description") map { _.as[String] }
  lazy val issued = attributes("@issued").as[String]
  lazy val issuerID = attributes("@issuerID").as[BigInt]
  lazy val medalID = attributes("@medalID").as[BigInt]
  lazy val reason = attributes("@reason").as[String]
  lazy val status = attributes("@status").as[String]
  lazy val title = attributes.get("@title") map { _.as[String] }
}
