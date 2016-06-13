package eveapi.xml.client.endpoints

import eveapi.xml.corp
import eveapi.xml.client._

class Corp(baseurl: String, apikey: Option[XmlApiKey]) {
  def AccountBalance() = new ApiRequest[corp.AccountBalance.Eveapi](baseurl, "corp/AccountBalance.xml.aspx", apikey).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def ContactList()  = new ApiRequest[corp.ContactList.Eveapi](baseurl, "corp/ContactList.xml.aspx", apikey).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset)}
  def Standings() = new ApiRequest[corp.Standings.Eveapi](baseurl, "corp/Standings.xml.aspx", apikey).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.corporationNPCStandings.rowset)}
}
