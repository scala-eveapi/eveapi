// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.eve.ErrorList


case class Eveapi(currentTime: String,
  result: eveapi.xml.eve.ErrorList.Result,
  cachedUntil: String,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

      


case class Result(rowset: eveapi.xml.eve.ErrorList.Rowset)
      


case class Rowset(row: Seq[eveapi.xml.eve.ErrorList.Row] = Nil,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

      


case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val errorCode = attributes("@errorCode").as[BigInt]
  lazy val errorText = attributes("@errorText").as[String]
}

      

