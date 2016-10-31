// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.corp.Standings

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.corp.Standings.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(
  corporationNPCStandings: eveapi.xml.account.corp.Standings.CorporationNPCStandings)

case class CorporationNPCStandings(rowset: eveapi.xml.account.corp.Standings.Rowset*)

case class Rowset(row: Seq[eveapi.xml.account.corp.Standings.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val fromID = attributes("@fromID").as[BigInt]
  lazy val fromName = attributes("@fromName").as[String]
  lazy val standing = attributes("@standing").as[BigDecimal]
}
