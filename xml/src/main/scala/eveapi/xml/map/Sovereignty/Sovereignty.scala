// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.map.Sovereignty

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.map.Sovereignty.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.account.map.Sovereignty.Rowset, dataTime: String)

case class Rowset(row: Seq[eveapi.xml.account.map.Sovereignty.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val allianceID = attributes("@allianceID").as[BigInt]
  lazy val corporationID = attributes("@corporationID").as[BigInt]
  lazy val factionID = attributes("@factionID").as[BigInt]
  lazy val solarSystemID = attributes("@solarSystemID").as[BigInt]
  lazy val solarSystemName = attributes("@solarSystemName").as[String]
}
