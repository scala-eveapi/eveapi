// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.WalletJournal

case class Eveapi(currentTime: String,
                  result: eveapi.xml.char.WalletJournal.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(rowset: eveapi.xml.char.WalletJournal.Rowset)

case class Rowset(row: Seq[eveapi.xml.char.WalletJournal.Row] = Nil,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes("@columns").as[String]
  lazy val key = attributes("@key").as[String]
  lazy val name = attributes("@name").as[String]
}

case class Row(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val amount = attributes("@amount").as[BigDecimal]
  lazy val argID1 = attributes("@argID1").as[BigInt]
  lazy val argName1 = attributes("@argName1").as[String]
  lazy val balance = attributes("@balance").as[BigDecimal]
  lazy val date = attributes("@date").as[String]
  lazy val owner1TypeID = attributes("@owner1TypeID").as[BigInt]
  lazy val owner2TypeID = attributes("@owner2TypeID").as[BigInt]
  lazy val ownerID1 = attributes("@ownerID1").as[BigInt]
  lazy val ownerID2 = attributes("@ownerID2").as[BigInt]
  lazy val ownerName1 = attributes("@ownerName1").as[String]
  lazy val ownerName2 = attributes("@ownerName2").as[String]
  lazy val reason = attributes("@reason").as[String]
  lazy val refID = attributes("@refID").as[BigInt]
  lazy val refTypeID = attributes("@refTypeID").as[BigInt]
  lazy val taxAmount = attributes("@taxAmount").as[String]
  lazy val taxReceiverID = attributes("@taxReceiverID").as[String]
}