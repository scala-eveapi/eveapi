package eveapi.xml.client

import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration._


class EVEAPI(baseurl: String = "https://api.eveonline.com/", key: Option[XmlApiKey] = None)(implicit val ec: ExecutionContext) {
  val account = new endpoints.Account(baseurl, key)
  val char = new endpoints.Character(baseurl, key)
  val corp = new endpoints.Corp(baseurl, key)
  val eve = new endpoints.Eve(baseurl)
  val map = new endpoints.Map(baseurl)
  val server = new endpoints.Server(baseurl)
}
