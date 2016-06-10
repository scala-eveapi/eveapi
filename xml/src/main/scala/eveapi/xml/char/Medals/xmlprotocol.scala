// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.Medals

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.char.Medals.Foo](node)
val document = scalaxb.toXML[eveapi.xml.char.Medals.Foo](obj, "foo", eveapi.xml.char.Medals.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val MedalsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.char.Medals.Eveapi] = new DefaultMedalsEveapiFormat {}
  implicit lazy val MedalsResultFormat: scalaxb.XMLFormat[eveapi.xml.char.Medals.Result] = new DefaultMedalsResultFormat {}
  implicit lazy val MedalsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.char.Medals.Rowset] = new DefaultMedalsRowsetFormat {}
  implicit lazy val MedalsRowFormat: scalaxb.XMLFormat[eveapi.xml.char.Medals.Row] = new DefaultMedalsRowFormat {}

  trait DefaultMedalsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.char.Medals.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.Medals.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.char.Medals.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.char.Medals.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.Medals.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.Medals.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.char.Medals.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultMedalsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.char.Medals.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.Medals.Result] =
      phrase(safeRep(scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.char.Medals.Result(p1.toSeq map { scalaxb.fromXML[eveapi.xml.char.Medals.Rowset](_, scalaxb.ElemName(node) :: stack) }: _*) })
    
    def writesChildNodes(__obj: eveapi.xml.char.Medals.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.rowset flatMap { scalaxb.toXML[eveapi.xml.char.Medals.Rowset](_, None, Some("rowset"), __scope, false) })

  }

  trait DefaultMedalsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.char.Medals.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.Medals.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.char.Medals.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.char.Medals.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.Medals.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.Medals.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.char.Medals.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultMedalsRowFormat extends scalaxb.XMLFormat[eveapi.xml.char.Medals.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.char.Medals.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.char.Medals.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.char.Medals.Row(scala.collection.immutable.ListMap(List(
        (node \ "@corporationID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@corporationID" -> _ },
        (node \ "@description").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@description" -> _ },
        (node \ "@issued").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@issued" -> _ },
        (node \ "@issuerID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@issuerID" -> _ },
        (node \ "@medalID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@medalID" -> _ },
        (node \ "@reason").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@reason" -> _ },
        (node \ "@status").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@status" -> _ },
        (node \ "@title").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@title" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.char.Medals.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@corporationID", _) => __obj.corporationID foreach { x => attr = scala.xml.Attribute(null, "corporationID", x.toString, attr) }
        case ("@description", _) => __obj.description foreach { x => attr = scala.xml.Attribute(null, "description", x.toString, attr) }
        case ("@issued", _) => attr = scala.xml.Attribute(null, "issued", __obj.issued.toString, attr)
        case ("@issuerID", _) => attr = scala.xml.Attribute(null, "issuerID", __obj.issuerID.toString, attr)
        case ("@medalID", _) => attr = scala.xml.Attribute(null, "medalID", __obj.medalID.toString, attr)
        case ("@reason", _) => attr = scala.xml.Attribute(null, "reason", __obj.reason.toString, attr)
        case ("@status", _) => attr = scala.xml.Attribute(null, "status", __obj.status.toString, attr)
        case ("@title", _) => __obj.title foreach { x => attr = scala.xml.Attribute(null, "title", x.toString, attr) }
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.Medals.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}

