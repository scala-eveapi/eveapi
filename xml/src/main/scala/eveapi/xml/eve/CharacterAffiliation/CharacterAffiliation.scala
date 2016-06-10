// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.eve.CharacterAffiliation

case class Eveapi(currentTime: String,
                  result: eveapi.xml.eve.CharacterAffiliation.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.eve.CharacterAffiliation.Rowset)

case class Rowset(row: Seq[eveapi.xml.eve.CharacterAffiliation.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val allianceID = attributes("@allianceID").as[BigInt]
  lazy val allianceName = attributes("@allianceName").as[String]
  lazy val characterID = attributes("@characterID").as[BigInt]
  lazy val characterName = attributes("@characterName").as[String]
  lazy val corporationID = attributes("@corporationID").as[BigInt]
  lazy val corporationName = attributes("@corporationName").as[String]
  lazy val factionID = attributes("@factionID").as[BigInt]
  lazy val factionName = attributes("@factionName").as[String]
}
