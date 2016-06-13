package eveapi.xml.client

import org.http4s.util.{CaseInsensitiveString, Writer}
import org.http4s.{Query, Header, Request, Uri}
import org.http4s.client.blaze.{PooledHttp1Client, SimpleHttp1Client}

import scala.util.{Try, Failure, Success}
import scala.xml.{Elem, XML}
import scalaz.concurrent.Task


class ApiRequest[T](base: String, endpoint: String,  auth: Option[XmlApiKey] = None, args: Map[String, String] = Map())(implicit val parser: scalaxb.XMLFormat[T]) {

  val simpleClient = PooledHttp1Client()

  def apply(): Task[T] = {
    Uri.fromString(base+endpoint).map { uri =>
      new Request(uri = uri)
          .putHeaders(
            Header("User-Agent", "scala-eveapi")
          )

    }
  }
    /*
    val mysvc = url(base+endpoint).addHeader("User-Agent", "pizza-eveapi")
    var req = mysvc.GET
    // add API key
    req = auth match {
      case Some(xmlapikey) =>
        xmlapikey match {
          case a: ApiKey =>
            req.addQueryParameter("keyID", a.keyId.toString).addQueryParameter("vCode", a.vCode)
          case c: CrestApiKey =>
            req.addQueryParameter("accessToken", c.accessToken).addQueryParameter("accessType", c.accessType)
        }
      case None => req
    }
    // add arguments
    req = args.foldLeft(req)((r, kv) => r.addQueryParameter(kv._1, kv._2))
    // return as future
    val response = Http(req OK as.String)
    response.map{ s => scalaxb.fromXML[T](XML.loadString(s)) }
  }
  */
}
