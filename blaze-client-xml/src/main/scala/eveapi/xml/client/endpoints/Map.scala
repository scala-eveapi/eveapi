package eveapi.xml.client.endpoints

import scala.concurrent.Future
import scala.util.Try

import eveapi.xml.map
import eveapi.xml.client._

class Map(baseurl: String) {
  def Sovereignty(): Future[Seq[map.Sovereignty.Row]] = {
    new ApiRequest[map.Sovereignty.Eveapi](baseurl, "Map/Sovereignty.xml.aspx")(map.Sovereignty.SovereigntyEveapiFormat).apply().map(_.result.rowset.row)
  }
  def FacWarSystems(): Future[Seq[map.FacWarSystems.Row]] = {
    new ApiRequest[map.FacWarSystems.Eveapi](baseurl, "Map/FacWarSystems.xml.aspx")(map.FacWarSystems.FacWarSystemsEveapiFormat).apply().map(_.result.rowset.row)
  }
  def Kills(): Future[Seq[map.Kills.Row]] = {
    new ApiRequest[map.Kills.Eveapi](baseurl, "Map/Kills.xml.aspx")(map.Kills.KillsEveapiFormat).apply().map(_.result.rowset.row)
  }
  def Jumps(): Future[Seq[map.Jumps.Row]] = {
    new ApiRequest[map.Jumps.Eveapi](baseurl, "Map/Jumps.xml.aspx")(map.Jumps.JumpsEveapiFormat).apply().map(_.result.rowset.row)
  }
}
