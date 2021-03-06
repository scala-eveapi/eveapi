// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.eve.CharacterID

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.account.eve.CharacterID.Foo](node)
val document = scalaxb.toXML[eveapi.xml.account.eve.CharacterID.Foo](obj, "foo", eveapi.xml.account.eve.CharacterID.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val CharacterIDEveapiFormat: scalaxb.XMLFormat[eveapi.xml.account.eve.CharacterID.Eveapi] = new DefaultCharacterIDEveapiFormat {}
  implicit lazy val CharacterIDResultFormat: scalaxb.XMLFormat[eveapi.xml.account.eve.CharacterID.Result] = new DefaultCharacterIDResultFormat {}
  implicit lazy val CharacterIDRowsetFormat: scalaxb.XMLFormat[eveapi.xml.account.eve.CharacterID.Rowset] = new DefaultCharacterIDRowsetFormat {}
  implicit lazy val CharacterIDRowFormat: scalaxb.XMLFormat[eveapi.xml.account.eve.CharacterID.Row] = new DefaultCharacterIDRowFormat {}

  trait DefaultCharacterIDEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.account.eve.CharacterID.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.eve.CharacterID.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.account.eve.CharacterID.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.account.eve.CharacterID.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.account.eve.CharacterID.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterID.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.account.eve.CharacterID.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultCharacterIDResultFormat extends scalaxb.ElemNameParser[eveapi.xml.account.eve.CharacterID.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.eve.CharacterID.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.account.eve.CharacterID.Result(scalaxb.fromXML[eveapi.xml.account.eve.CharacterID.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterID.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.account.eve.CharacterID.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultCharacterIDRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.account.eve.CharacterID.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.eve.CharacterID.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.account.eve.CharacterID.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.account.eve.CharacterID.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.account.eve.CharacterID.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterID.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.account.eve.CharacterID.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultCharacterIDRowFormat extends scalaxb.XMLFormat[eveapi.xml.account.eve.CharacterID.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.account.eve.CharacterID.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.account.eve.CharacterID.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.account.eve.CharacterID.Row(scala.collection.immutable.ListMap(List(
        (node \ "@characterID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@characterID" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.account.eve.CharacterID.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@characterID", _) => attr = scala.xml.Attribute(null, "characterID", __obj.characterID.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterID.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}

