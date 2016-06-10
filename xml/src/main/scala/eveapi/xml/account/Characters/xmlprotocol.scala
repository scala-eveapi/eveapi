// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.Characters

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.account.Characters.Foo](node)
val document = scalaxb.toXML[eveapi.xml.account.Characters.Foo](obj, "foo", eveapi.xml.account.Characters.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val CharactersEveapiFormat: scalaxb.XMLFormat[eveapi.xml.account.Characters.Eveapi] = new DefaultCharactersEveapiFormat {}
  implicit lazy val CharactersResultFormat: scalaxb.XMLFormat[eveapi.xml.account.Characters.Result] = new DefaultCharactersResultFormat {}
  implicit lazy val CharactersRowsetFormat: scalaxb.XMLFormat[eveapi.xml.account.Characters.Rowset] = new DefaultCharactersRowsetFormat {}
  implicit lazy val CharactersRowFormat: scalaxb.XMLFormat[eveapi.xml.account.Characters.Row] = new DefaultCharactersRowFormat {}

  trait DefaultCharactersEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.account.Characters.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.Characters.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.account.Characters.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.account.Characters.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.account.Characters.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.Characters.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.account.Characters.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultCharactersResultFormat extends scalaxb.ElemNameParser[eveapi.xml.account.Characters.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.Characters.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.account.Characters.Result(scalaxb.fromXML[eveapi.xml.account.Characters.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.account.Characters.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.account.Characters.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultCharactersRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.account.Characters.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.Characters.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.account.Characters.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.account.Characters.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.account.Characters.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.Characters.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.account.Characters.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultCharactersRowFormat extends scalaxb.XMLFormat[eveapi.xml.account.Characters.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.account.Characters.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.account.Characters.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.account.Characters.Row(scala.collection.immutable.ListMap(List(
        (node \ "@allianceID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@allianceID" -> _ },
        (node \ "@allianceName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@allianceName" -> _ },
        (node \ "@characterID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@characterID" -> _ },
        (node \ "@corporationID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@corporationID" -> _ },
        (node \ "@corporationName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@corporationName" -> _ },
        (node \ "@factionID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@factionID" -> _ },
        (node \ "@factionName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@factionName" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.account.Characters.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@allianceID", _) => attr = scala.xml.Attribute(null, "allianceID", __obj.allianceID.toString, attr)
        case ("@allianceName", _) => attr = scala.xml.Attribute(null, "allianceName", __obj.allianceName.toString, attr)
        case ("@characterID", _) => attr = scala.xml.Attribute(null, "characterID", __obj.characterID.toString, attr)
        case ("@corporationID", _) => attr = scala.xml.Attribute(null, "corporationID", __obj.corporationID.toString, attr)
        case ("@corporationName", _) => attr = scala.xml.Attribute(null, "corporationName", __obj.corporationName.toString, attr)
        case ("@factionID", _) => attr = scala.xml.Attribute(null, "factionID", __obj.factionID.toString, attr)
        case ("@factionName", _) => attr = scala.xml.Attribute(null, "factionName", __obj.factionName.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.Characters.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}
