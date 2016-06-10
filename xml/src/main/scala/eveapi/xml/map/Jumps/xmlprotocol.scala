// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.map.Jumps

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.map.Jumps.Foo](node)
val document = scalaxb.toXML[eveapi.xml.map.Jumps.Foo](obj, "foo", eveapi.xml.map.Jumps.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val JumpsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.map.Jumps.Eveapi] = new DefaultJumpsEveapiFormat {}
  implicit lazy val JumpsResultFormat: scalaxb.XMLFormat[eveapi.xml.map.Jumps.Result] = new DefaultJumpsResultFormat {}
  implicit lazy val JumpsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.map.Jumps.Rowset] = new DefaultJumpsRowsetFormat {}
  implicit lazy val JumpsRowFormat: scalaxb.XMLFormat[eveapi.xml.map.Jumps.Row] = new DefaultJumpsRowFormat {}

  trait DefaultJumpsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.map.Jumps.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.map.Jumps.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.map.Jumps.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.map.Jumps.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.map.Jumps.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.map.Jumps.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.map.Jumps.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultJumpsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.map.Jumps.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.map.Jumps.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ~ 
      (scalaxb.ElemName(None, "dataTime")) ^^
      { case p1 ~ p2 =>
      eveapi.xml.map.Jumps.Result(scalaxb.fromXML[eveapi.xml.map.Jumps.Rowset](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p2, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.map.Jumps.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[eveapi.xml.map.Jumps.Rowset](__obj.rowset, None, Some("rowset"), __scope, false),
        scalaxb.toXML[String](__obj.dataTime, None, Some("dataTime"), __scope, false))

  }

  trait DefaultJumpsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.map.Jumps.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.map.Jumps.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.map.Jumps.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.map.Jumps.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.map.Jumps.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.map.Jumps.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.map.Jumps.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultJumpsRowFormat extends scalaxb.XMLFormat[eveapi.xml.map.Jumps.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.map.Jumps.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.map.Jumps.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.map.Jumps.Row(scala.collection.immutable.ListMap(List(
        (node \ "@shipJumps").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@shipJumps" -> _ },
        (node \ "@solarSystemID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@solarSystemID" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.map.Jumps.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@shipJumps", _) => attr = scala.xml.Attribute(null, "shipJumps", __obj.shipJumps.toString, attr)
        case ("@solarSystemID", _) => attr = scala.xml.Attribute(null, "solarSystemID", __obj.solarSystemID.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.map.Jumps.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}

