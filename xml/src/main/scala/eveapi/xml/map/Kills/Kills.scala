// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.map.Kills

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.map.Kills.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.account.map.Kills.Rowset, dataTime: String)

case class Rowset(row: Seq[eveapi.xml.account.map.Kills.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val factionKills = attributes("@factionKills").as[BigInt]
  lazy val podKills = attributes("@podKills").as[BigInt]
  lazy val shipKills = attributes("@shipKills").as[BigInt]
  lazy val solarSystemID = attributes("@solarSystemID").as[BigInt]
}
