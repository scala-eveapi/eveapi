// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.AccountStatus

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.AccountStatus.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(paidUntil: String,
                  createDate: String,
                  logonCount: BigInt,
                  logonMinutes: BigInt,
                  rowset: eveapi.xml.account.AccountStatus.Rowset)

case class Rowset(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}
