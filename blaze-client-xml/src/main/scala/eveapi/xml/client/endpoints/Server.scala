package eveapi.xml.client.endpoints

import eveapi.xml.server
import eveapi.xml.client._

class Server(baseurl: String) {
  def ServerStatus() = new ApiRequest[server.ServerStatus.Eveapi](baseurl, "Server/ServerStatus.xml.aspx")(server.ServerStatus.ServerStatusEveapiFormat).apply().map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result))
}
