// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.eve.TypeName


case class Eveapi(currentTime: String,
  result: eveapi.xml.eve.TypeName.Result,
  cachedUntil: String,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

      


case class Result(rowset: eveapi.xml.eve.TypeName.Rowset)
      


case class Rowset(row: Seq[eveapi.xml.eve.TypeName.Row] = Nil,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

      


case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val typeID = attributes("@typeID").as[BigInt]
  lazy val typeName = attributes("@typeName").as[String]
}

      

