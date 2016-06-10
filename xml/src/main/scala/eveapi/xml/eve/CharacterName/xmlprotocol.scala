// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.eve.CharacterName

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.eve.CharacterName.Foo](node)
val document = scalaxb.toXML[eveapi.xml.eve.CharacterName.Foo](obj, "foo", eveapi.xml.eve.CharacterName.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val CharacterNameEveapiFormat: scalaxb.XMLFormat[eveapi.xml.eve.CharacterName.Eveapi] = new DefaultCharacterNameEveapiFormat {}
  implicit lazy val CharacterNameResultFormat: scalaxb.XMLFormat[eveapi.xml.eve.CharacterName.Result] = new DefaultCharacterNameResultFormat {}
  implicit lazy val CharacterNameRowsetFormat: scalaxb.XMLFormat[eveapi.xml.eve.CharacterName.Rowset] = new DefaultCharacterNameRowsetFormat {}
  implicit lazy val CharacterNameRowFormat: scalaxb.XMLFormat[eveapi.xml.eve.CharacterName.Row] = new DefaultCharacterNameRowFormat {}

  trait DefaultCharacterNameEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.eve.CharacterName.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.eve.CharacterName.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.eve.CharacterName.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.eve.CharacterName.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.eve.CharacterName.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.eve.CharacterName.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.eve.CharacterName.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultCharacterNameResultFormat extends scalaxb.ElemNameParser[eveapi.xml.eve.CharacterName.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.eve.CharacterName.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.eve.CharacterName.Result(scalaxb.fromXML[eveapi.xml.eve.CharacterName.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.eve.CharacterName.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.eve.CharacterName.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultCharacterNameRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.eve.CharacterName.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.eve.CharacterName.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.eve.CharacterName.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.eve.CharacterName.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.eve.CharacterName.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.eve.CharacterName.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.eve.CharacterName.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultCharacterNameRowFormat extends scalaxb.XMLFormat[eveapi.xml.eve.CharacterName.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.eve.CharacterName.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.eve.CharacterName.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.eve.CharacterName.Row(scala.collection.immutable.ListMap(List(
        (node \ "@characterID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@characterID" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.eve.CharacterName.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@characterID", _) => attr = scala.xml.Attribute(null, "characterID", __obj.characterID.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.eve.CharacterName.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}
