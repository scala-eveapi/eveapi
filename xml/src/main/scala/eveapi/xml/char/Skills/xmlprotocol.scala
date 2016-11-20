// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.char.Skills

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.account.char.Skills.Foo](node)
val document = scalaxb.toXML[eveapi.xml.account.char.Skills.Foo](obj, "foo", eveapi.xml.account.char.Skills.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val SkillsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.account.char.Skills.Eveapi] = new DefaultSkillsEveapiFormat {}
  implicit lazy val SkillsResultFormat: scalaxb.XMLFormat[eveapi.xml.account.char.Skills.Result] = new DefaultSkillsResultFormat {}
  implicit lazy val SkillsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.account.char.Skills.Rowset] = new DefaultSkillsRowsetFormat {}
  implicit lazy val SkillsRowFormat: scalaxb.XMLFormat[eveapi.xml.account.char.Skills.Row] = new DefaultSkillsRowFormat {}

  trait DefaultSkillsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.account.char.Skills.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.char.Skills.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.account.char.Skills.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.account.char.Skills.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.account.char.Skills.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.char.Skills.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.account.char.Skills.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultSkillsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.account.char.Skills.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.char.Skills.Result] =
      phrase((scalaxb.ElemName(None, "freeSkillPoints")) ~ 
      (scalaxb.ElemName(None, "rowset")) ^^
      { case p1 ~ p2 =>
      eveapi.xml.account.char.Skills.Result(scalaxb.fromXML[BigInt](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.account.char.Skills.Rowset](p2, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.account.char.Skills.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[BigInt](__obj.freeSkillPoints, None, Some("freeSkillPoints"), __scope, false),
        scalaxb.toXML[eveapi.xml.account.char.Skills.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultSkillsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.account.char.Skills.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.char.Skills.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.account.char.Skills.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.account.char.Skills.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.account.char.Skills.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.char.Skills.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.account.char.Skills.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultSkillsRowFormat extends scalaxb.XMLFormat[eveapi.xml.account.char.Skills.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.account.char.Skills.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.account.char.Skills.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.account.char.Skills.Row(scala.collection.immutable.ListMap(List(
        (node \ "@level").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@level" -> _ },
        (node \ "@published").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@published" -> _ },
        (node \ "@skillpoints").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@skillpoints" -> _ },
        (node \ "@typeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@typeID" -> _ },
        (node \ "@typeName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@typeName" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.account.char.Skills.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@level", _) => attr = scala.xml.Attribute(null, "level", __obj.level.toString, attr)
        case ("@published", _) => attr = scala.xml.Attribute(null, "published", __obj.published.toString, attr)
        case ("@skillpoints", _) => attr = scala.xml.Attribute(null, "skillpoints", __obj.skillpoints.toString, attr)
        case ("@typeID", _) => attr = scala.xml.Attribute(null, "typeID", __obj.typeID.toString, attr)
        case ("@typeName", _) => attr = scala.xml.Attribute(null, "typeName", __obj.typeName.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.char.Skills.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}
