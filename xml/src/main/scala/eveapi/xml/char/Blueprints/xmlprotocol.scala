// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.Blueprints

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.char.Blueprints.Foo](node)
val document = scalaxb.toXML[eveapi.xml.char.Blueprints.Foo](obj, "foo", eveapi.xml.char.Blueprints.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val BlueprintsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.char.Blueprints.Eveapi] = new DefaultBlueprintsEveapiFormat {}
  implicit lazy val BlueprintsResultFormat: scalaxb.XMLFormat[eveapi.xml.char.Blueprints.Result] = new DefaultBlueprintsResultFormat {}
  implicit lazy val BlueprintsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.char.Blueprints.Rowset] = new DefaultBlueprintsRowsetFormat {}
  implicit lazy val BlueprintsRowFormat: scalaxb.XMLFormat[eveapi.xml.char.Blueprints.Row] = new DefaultBlueprintsRowFormat {}

  trait DefaultBlueprintsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.char.Blueprints.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.Blueprints.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.char.Blueprints.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.char.Blueprints.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.Blueprints.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.Blueprints.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.char.Blueprints.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultBlueprintsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.char.Blueprints.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.Blueprints.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.char.Blueprints.Result(scalaxb.fromXML[eveapi.xml.char.Blueprints.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.char.Blueprints.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.char.Blueprints.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultBlueprintsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.char.Blueprints.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.Blueprints.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.char.Blueprints.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.char.Blueprints.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.Blueprints.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.Blueprints.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.char.Blueprints.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultBlueprintsRowFormat extends scalaxb.XMLFormat[eveapi.xml.char.Blueprints.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.char.Blueprints.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.char.Blueprints.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.char.Blueprints.Row(scala.collection.immutable.ListMap(List(
        (node \ "@flagID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@flagID" -> _ },
        (node \ "@itemID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@itemID" -> _ },
        (node \ "@locationID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@locationID" -> _ },
        (node \ "@materialEfficiency").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@materialEfficiency" -> _ },
        (node \ "@quantity").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@quantity" -> _ },
        (node \ "@runs").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@runs" -> _ },
        (node \ "@timeEfficiency").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@timeEfficiency" -> _ },
        (node \ "@typeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@typeID" -> _ },
        (node \ "@typeName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@typeName" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.char.Blueprints.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@flagID", _) => attr = scala.xml.Attribute(null, "flagID", __obj.flagID.toString, attr)
        case ("@itemID", _) => attr = scala.xml.Attribute(null, "itemID", __obj.itemID.toString, attr)
        case ("@locationID", _) => attr = scala.xml.Attribute(null, "locationID", __obj.locationID.toString, attr)
        case ("@materialEfficiency", _) => attr = scala.xml.Attribute(null, "materialEfficiency", __obj.materialEfficiency.toString, attr)
        case ("@quantity", _) => attr = scala.xml.Attribute(null, "quantity", __obj.quantity.toString, attr)
        case ("@runs", _) => attr = scala.xml.Attribute(null, "runs", __obj.runs.toString, attr)
        case ("@timeEfficiency", _) => attr = scala.xml.Attribute(null, "timeEfficiency", __obj.timeEfficiency.toString, attr)
        case ("@typeID", _) => attr = scala.xml.Attribute(null, "typeID", __obj.typeID.toString, attr)
        case ("@typeName", _) => attr = scala.xml.Attribute(null, "typeName", __obj.typeName.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.Blueprints.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}

