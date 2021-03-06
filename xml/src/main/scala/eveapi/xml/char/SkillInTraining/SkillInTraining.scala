// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.char.SkillInTraining

case class Eveapi(currentTime: String,
                  result: eveapi.xml.account.char.SkillInTraining.Result,
                  cachedUntil: String,
                  attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val version = attributes("@version").as[BigInt]
}

case class Result(currentTQTime: eveapi.xml.account.char.SkillInTraining.CurrentTQTime,
                  trainingEndTime: String,
                  trainingStartTime: String,
                  trainingTypeID: BigInt,
                  trainingStartSP: BigInt,
                  trainingDestinationSP: BigInt,
                  trainingToLevel: BigInt,
                  skillInTraining: BigInt)

case class CurrentTQTime(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
                         attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val offset = attributes("@offset").as[BigInt]
}
