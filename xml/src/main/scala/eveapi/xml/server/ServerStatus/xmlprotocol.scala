// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.server.ServerStatus

import scala.concurrent.Future

/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.server.ServerStatus.Foo](node)
val document = scalaxb.toXML[eveapi.xml.server.ServerStatus.Foo](obj, "foo", eveapi.xml.server.ServerStatus.defaultScope)
  **/
object `package` extends XMLProtocol {}

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext =
    scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(
      Some("xs") -> "http://www.w3.org/2001/XMLSchema",
      Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val ServerStatusEveapiFormat: scalaxb.XMLFormat[
      eveapi.xml.server.ServerStatus.Eveapi] =
    new DefaultServerStatusEveapiFormat {}
  implicit lazy val ServerStatusResultFormat: scalaxb.XMLFormat[
      eveapi.xml.server.ServerStatus.Result] =
    new DefaultServerStatusResultFormat {}

  trait DefaultServerStatusEveapiFormat
      extends scalaxb.ElemNameParser[eveapi.xml.server.ServerStatus.Eveapi] {
    val targetNamespace: Option[String] = None

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName])
      : Parser[eveapi.xml.server.ServerStatus.Eveapi] =
      phrase(
          (scalaxb.ElemName(None, "currentTime")) ~
          (scalaxb.ElemName(None, "result")) ~
          (scalaxb.ElemName(None, "cachedUntil")) ^^ {
        case p1 ~ p2 ~ p3 =>
          eveapi.xml.server.ServerStatus.Eveapi(
              scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[eveapi.xml.server.ServerStatus.Result](
                  p2, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
              scala.collection.immutable.ListMap(List(
                      (node \ "@version").headOption map {
                    x =>
                      scalaxb.DataRecord(x,
                                         node,
                                         scalaxb.fromXML[BigInt](
                                             x,
                                             scalaxb.ElemName(node) :: stack))
                  } map { "@version" -> _ }
                  ).flatten[(String, scalaxb.DataRecord[Any])]: _*))
      })

    override def writesAttribute(
      __obj: eveapi.xml.server.ServerStatus.Eveapi,
      __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) =>
          attr =
            scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) =>
          attr = scala.xml.Attribute(
              (x.namespace map { __scope.getPrefix(_) }).orNull,
              x.key.orNull,
              x.value.toString,
              attr)
      }
      attr
    }

    def writesChildNodes(
      __obj: eveapi.xml.server.ServerStatus.Eveapi,
      __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(
          scalaxb.toXML[String](
              __obj.currentTime, None, Some("currentTime"), __scope, false),
          scalaxb.toXML[eveapi.xml.server.ServerStatus.Result](
              __obj.result, None, Some("result"), __scope, false),
          scalaxb.toXML[String](
              __obj.cachedUntil, None, Some("cachedUntil"), __scope, false))
  }

  trait DefaultServerStatusResultFormat
      extends scalaxb.ElemNameParser[eveapi.xml.server.ServerStatus.Result] {
    val targetNamespace: Option[String] = None

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName])
      : Parser[eveapi.xml.server.ServerStatus.Result] =
      phrase(
          (scalaxb.ElemName(None, "serverOpen")) ~
          (scalaxb.ElemName(None, "onlinePlayers")) ^^ {
        case p1 ~ p2 =>
          eveapi.xml.server.ServerStatus.Result(
              scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[BigInt](p2, scalaxb.ElemName(node) :: stack))
      })

    def writesChildNodes(
      __obj: eveapi.xml.server.ServerStatus.Result,
      __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(
          scalaxb.toXML[String](
              __obj.serverOpen, None, Some("serverOpen"), __scope, false),
          scalaxb.toXML[BigInt](__obj.onlinePlayers,
                                None,
                                Some("onlinePlayers"),
                                __scope,
                                false))
  }
}
