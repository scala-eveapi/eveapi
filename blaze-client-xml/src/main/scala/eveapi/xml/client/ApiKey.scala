package eveapi.xml.client

import org.http4s.Uri

trait XmlApiKey
case class ApiKey(keyId: Int, vCode: String) extends XmlApiKey {
  def addQueryParams(uri: Uri): Uri = {
    uri.withQueryParam("keyID", keyId.toString)
       .withQueryParam("vCode", vCode)
  }
}
case class SSOApiKey(accessToken: String, accessType: String = "character") extends XmlApiKey {
  def addQueryParams(uri: Uri): Uri = {
    uri.withQueryParam("accessToken", accessToken)
       .withQueryParam("accessType", accessType)
  }
}
