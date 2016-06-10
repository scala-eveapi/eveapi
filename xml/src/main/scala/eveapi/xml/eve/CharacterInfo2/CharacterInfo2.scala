// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.eve.CharacterInfo2


case class Eveapi(currentTime: String,
  result: eveapi.xml.eve.CharacterInfo2.Result,
  cachedUntil: String,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

      


case class Result(characterID: BigInt,
  characterName: String,
  race: String,
  bloodlineID: BigInt,
  bloodline: String,
  ancestryID: BigInt,
  ancestry: String,
  corporationID: BigInt,
  corporation: String,
  corporationDate: String,
  securityStatus: BigDecimal,
  rowset: eveapi.xml.eve.CharacterInfo2.Rowset)
      


case class Rowset(row: Seq[eveapi.xml.eve.CharacterInfo2.Row] = Nil,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

      


case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val corporationID = attributes("@corporationID").as[BigInt]
  lazy val corporationName = attributes("@corporationName").as[String]
  lazy val recordID = attributes("@recordID").as[BigInt]
  lazy val startDate = attributes("@startDate").as[String]
}

      

