// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.char.AccountBalance


case class Eveapi(currentTime: String,
  result: eveapi.xml.account.char.AccountBalance.Result,
  cachedUntil: String,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

      


case class Result(rowset: eveapi.xml.account.char.AccountBalance.Rowset)
      


case class Rowset(row: eveapi.xml.account.char.AccountBalance.Row,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

      


case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val accountID = attributes("@accountID").as[BigInt]
  lazy val accountKey = attributes("@accountKey").as[BigInt]
  lazy val balance = attributes("@balance").as[BigDecimal]
}

      

