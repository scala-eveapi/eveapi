// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.char.Contracts

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.char.Contracts.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.account.char.Contracts.Rowset)

case class Rowset(row: Seq[eveapi.xml.account.char.Contracts.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val acceptorID = attributes("@acceptorID").as[BigInt]
  lazy val assigneeID = attributes("@assigneeID").as[BigInt]
  lazy val availability = attributes("@availability").as[String]
  lazy val buyout = attributes("@buyout").as[BigDecimal]
  lazy val collateral = attributes("@collateral").as[BigDecimal]
  lazy val contractID = attributes("@contractID").as[BigInt]
  lazy val dateAccepted = attributes("@dateAccepted").as[String]
  lazy val dateCompleted = attributes("@dateCompleted").as[String]
  lazy val dateExpired = attributes("@dateExpired").as[String]
  lazy val dateIssued = attributes("@dateIssued").as[String]
  lazy val endStationID = attributes("@endStationID").as[BigInt]
  lazy val forCorp = attributes("@forCorp").as[BigInt]
  lazy val issuerCorpID = attributes("@issuerCorpID").as[BigInt]
  lazy val issuerID = attributes("@issuerID").as[BigInt]
  lazy val numDays = attributes("@numDays").as[BigInt]
  lazy val price = attributes("@price").as[BigDecimal]
  lazy val reward = attributes("@reward").as[BigDecimal]
  lazy val startStationID = attributes("@startStationID").as[BigInt]
  lazy val status = attributes("@status").as[String]
  lazy val title = attributes("@title").as[String]
  lazy val typeValue = attributes("@type").as[String]
  lazy val volume = attributes("@volume").as[BigDecimal]
}
