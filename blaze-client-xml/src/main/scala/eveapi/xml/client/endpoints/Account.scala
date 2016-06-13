package eveapi.xml.client.endpoints

import eveapi.xml.account
import eveapi.xml.client.{XMLApiResponse, ApiRequest, XmlApiKey}
import eveapi.xml.client._

class Account(baseurl: String, apikey: Option[XmlApiKey]) {
  def AccountStatus() = new ApiRequest[account.AccountStatus.Eveapi](baseurl, "Account/AccountStatus.xml.aspx", apikey).apply().map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result))
  def APIKeyInfo() = new ApiRequest[account.APIKeyInfo.Eveapi](baseurl, "Account/APIKeyInfo.xml.aspx", apikey).apply().map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result))
  def Characters() = new ApiRequest[account.Characters.Eveapi](baseurl, "Account/Characters.xml.aspx", apikey).apply().map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result))
}
