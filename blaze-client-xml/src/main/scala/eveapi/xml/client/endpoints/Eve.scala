package eveapi.xml.client.endpoints

import eveapi.xml.client._
import eveapi.xml.eve

import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Left, Right}


class Eve(baseurl: String)(implicit ec: ExecutionContext) {
  def AllianceList() = new ApiRequest[eve.AllianceList.Eveapi](baseurl, "Eve/AllianceList.xml.aspx")(eve.AllianceList.AllianceListEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def CharacterAffiliation(ids: Seq[String]) = new ApiRequest[eve.CharacterAffiliation.Eveapi](baseurl, "Eve/CharacterAffiliation.xml.aspx", None, Map("ids" -> ids.mkString(",")))(eve.CharacterAffiliation.CharacterAffiliationEveapiFormat).apply().map {r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def CharacterID(ids: Seq[String]) = new ApiRequest[eve.CharacterID.Eveapi](baseurl, "Eve/CharacterID.xml.aspx", None, Map("names" -> ids.mkString(",")))(eve.CharacterID.CharacterIDEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  /*
  def CharacterInfo(id: Long): Future[Either[XMLApiResponse[eve.CharacterInfo2.Result], XMLApiResponse[eve.CharacterInfo.Result]]] = new DualApiRequest[eve.CharacterInfo.Eveapi, eve.CharacterInfo2.Eveapi](baseurl, "Eve/CharacterInfo.xml.aspx", None, Map("characterID" -> id.toString))(eve.CharacterInfo2.CharacterInfo2EveapiFormat, eve.CharacterInfo.CharacterInfoEveapiFormat).apply().map { v =>
    v match {
      case Left(l) => Left(new XMLApiResponse(l.currentTime.toDateTime, l.cachedUntil.toDateTime, l.result))
      case Right(r) => Right(new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result))
    }
  }
  */
  def CharacterName(ids: Seq[Long]) = new ApiRequest[eve.CharacterName.Eveapi](baseurl, "Eve/CharacterName.xml.aspx", None, Map{"ids" -> ids.mkString(",")})(eve.CharacterName.CharacterNameEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def ConquerableStationList() = new ApiRequest[eve.ConquerableStationList.Eveapi](baseurl, "Eve/ConquerableStationList.xml.aspx")(eve.ConquerableStationList.ConquerableStationListEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def ErrorList() = new ApiRequest[eve.ErrorList.Eveapi](baseurl, "Eve/ErrorList.xml.aspx")(eve.ErrorList.ErrorListEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def FacWarStats() = new ApiRequest[eve.FacWarStats.Eveapi](baseurl, "Eve/FacWarStats.xml.aspx")(eve.FacWarStats.FacWarStatsEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}
  def FacWarTopStats() = new ApiRequest[eve.FacWarTopStats.Eveapi](baseurl, "Eve/FacWarTopStats.xml.aspx")(eve.FacWarTopStats.FacWarTopStatsEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}
  def OwnerID(names: Seq[String]) = new ApiRequest[eve.OwnerID.Eveapi](baseurl, "Eve/OwnerID.xml.aspx", None, Map("names" -> names.mkString(",")))(eve.OwnerID.OwnerIDEveapiFormat).apply().map {r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def RefTypes() = new ApiRequest[eve.RefTypes.Eveapi](baseurl, "Eve/RefTypes.xml.aspx")(eve.RefTypes.RefTypesEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def TypeName(ids: Seq[Long]) = new ApiRequest[eve.TypeName.Eveapi](baseurl, "Eve/TypeName.xml.aspx")(eve.TypeName.TypeNameEveapiFormat).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
}
