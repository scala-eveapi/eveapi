// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.map.FacWarSystems

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.map.FacWarSystems.Foo](node)
val document = scalaxb.toXML[eveapi.xml.map.FacWarSystems.Foo](obj, "foo", eveapi.xml.map.FacWarSystems.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val FacWarSystemsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.map.FacWarSystems.Eveapi] = new DefaultFacWarSystemsEveapiFormat {}
  implicit lazy val FacWarSystemsResultFormat: scalaxb.XMLFormat[eveapi.xml.map.FacWarSystems.Result] = new DefaultFacWarSystemsResultFormat {}
  implicit lazy val FacWarSystemsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.map.FacWarSystems.Rowset] = new DefaultFacWarSystemsRowsetFormat {}
  implicit lazy val FacWarSystemsRowFormat: scalaxb.XMLFormat[eveapi.xml.map.FacWarSystems.Row] = new DefaultFacWarSystemsRowFormat {}

  trait DefaultFacWarSystemsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.map.FacWarSystems.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.map.FacWarSystems.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.map.FacWarSystems.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.map.FacWarSystems.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.map.FacWarSystems.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.map.FacWarSystems.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.map.FacWarSystems.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultFacWarSystemsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.map.FacWarSystems.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.map.FacWarSystems.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.map.FacWarSystems.Result(scalaxb.fromXML[eveapi.xml.map.FacWarSystems.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.map.FacWarSystems.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.map.FacWarSystems.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultFacWarSystemsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.map.FacWarSystems.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.map.FacWarSystems.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.map.FacWarSystems.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.map.FacWarSystems.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.map.FacWarSystems.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.map.FacWarSystems.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.map.FacWarSystems.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultFacWarSystemsRowFormat extends scalaxb.XMLFormat[eveapi.xml.map.FacWarSystems.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.map.FacWarSystems.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.map.FacWarSystems.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.map.FacWarSystems.Row(scala.collection.immutable.ListMap(List(
        (node \ "@contested").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@contested" -> _ },
        (node \ "@occupyingFactionID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@occupyingFactionID" -> _ },
        (node \ "@occupyingFactionName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@occupyingFactionName" -> _ },
        (node \ "@owningFactionID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@owningFactionID" -> _ },
        (node \ "@owningFactionName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@owningFactionName" -> _ },
        (node \ "@solarSystemID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@solarSystemID" -> _ },
        (node \ "@solarSystemName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@solarSystemName" -> _ },
        (node \ "@victoryPointThreshold").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@victoryPointThreshold" -> _ },
        (node \ "@victoryPoints").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@victoryPoints" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.map.FacWarSystems.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@contested", _) => attr = scala.xml.Attribute(null, "contested", __obj.contested.toString, attr)
        case ("@occupyingFactionID", _) => attr = scala.xml.Attribute(null, "occupyingFactionID", __obj.occupyingFactionID.toString, attr)
        case ("@occupyingFactionName", _) => attr = scala.xml.Attribute(null, "occupyingFactionName", __obj.occupyingFactionName.toString, attr)
        case ("@owningFactionID", _) => attr = scala.xml.Attribute(null, "owningFactionID", __obj.owningFactionID.toString, attr)
        case ("@owningFactionName", _) => attr = scala.xml.Attribute(null, "owningFactionName", __obj.owningFactionName.toString, attr)
        case ("@solarSystemID", _) => attr = scala.xml.Attribute(null, "solarSystemID", __obj.solarSystemID.toString, attr)
        case ("@solarSystemName", _) => attr = scala.xml.Attribute(null, "solarSystemName", __obj.solarSystemName.toString, attr)
        case ("@victoryPointThreshold", _) => attr = scala.xml.Attribute(null, "victoryPointThreshold", __obj.victoryPointThreshold.toString, attr)
        case ("@victoryPoints", _) => attr = scala.xml.Attribute(null, "victoryPoints", __obj.victoryPoints.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.map.FacWarSystems.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}
