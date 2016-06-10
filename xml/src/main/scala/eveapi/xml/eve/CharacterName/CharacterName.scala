// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.eve.CharacterName

case class Eveapi(currentTime: String,
                  result: eveapi.xml.eve.CharacterName.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.eve.CharacterName.Rowset)

case class Rowset(row: Seq[eveapi.xml.eve.CharacterName.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val characterID = attributes("@characterID").as[BigInt]
  lazy val name = attributes("@name").as[String]
}