// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.map.FacWarSystems

case class Eveapi(currentTime: String,
                  result: eveapi.xml.map.FacWarSystems.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.map.FacWarSystems.Rowset)

case class Rowset(row: Seq[eveapi.xml.map.FacWarSystems.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val contested = attributes("@contested").as[String]
  lazy val occupyingFactionID = attributes("@occupyingFactionID").as[BigInt]
  lazy val occupyingFactionName =
    attributes("@occupyingFactionName").as[String]
  lazy val owningFactionID = attributes("@owningFactionID").as[BigInt]
  lazy val owningFactionName = attributes("@owningFactionName").as[String]
  lazy val solarSystemID = attributes("@solarSystemID").as[BigInt]
  lazy val solarSystemName = attributes("@solarSystemName").as[String]
  lazy val victoryPointThreshold =
    attributes("@victoryPointThreshold").as[BigInt]
  lazy val victoryPoints = attributes("@victoryPoints").as[BigInt]
}
