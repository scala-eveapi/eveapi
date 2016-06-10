// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.MarketOrder

case class Eveapi(currentTime: String,
                  result: eveapi.xml.char.MarketOrder.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.char.MarketOrder.Rowset)

case class Rowset(row: Seq[eveapi.xml.char.MarketOrder.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val accountKey = attributes("@accountKey").as[BigInt]
  lazy val bid = attributes("@bid").as[BigInt]
  lazy val charID = attributes("@charID").as[BigInt]
  lazy val duration = attributes("@duration").as[BigInt]
  lazy val escrow = attributes("@escrow").as[BigDecimal]
  lazy val issued = attributes("@issued").as[String]
  lazy val minVolume = attributes("@minVolume").as[BigInt]
  lazy val orderID = attributes("@orderID").as[BigInt]
  lazy val orderState = attributes("@orderState").as[BigInt]
  lazy val price = attributes("@price").as[BigDecimal]
  lazy val range = attributes("@range").as[BigInt]
  lazy val stationID = attributes("@stationID").as[BigInt]
  lazy val typeID = attributes("@typeID").as[BigInt]
  lazy val volEntered = attributes("@volEntered").as[BigInt]
  lazy val volRemaining = attributes("@volRemaining").as[BigInt]
}