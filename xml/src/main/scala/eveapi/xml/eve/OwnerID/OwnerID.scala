// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.eve.OwnerID


case class Eveapi(currentTime: String,
  result: eveapi.xml.account.eve.OwnerID.Result,
  cachedUntil: String,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

      


case class Result(rowset: eveapi.xml.account.eve.OwnerID.Rowset)
      


case class Rowset(row: Seq[eveapi.xml.account.eve.OwnerID.Row] = Nil,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

      


case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val ownerGroupID = attributes("@ownerGroupID").as[BigInt]
  lazy val ownerID = attributes("@ownerID").as[BigInt]
  lazy val ownerName = attributes("@ownerName").as[String]
}

      

