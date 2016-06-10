// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.corp.Standings

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.corp.Standings.Foo](node)
val document = scalaxb.toXML[eveapi.xml.corp.Standings.Foo](obj, "foo", eveapi.xml.corp.Standings.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val StandingsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.corp.Standings.Eveapi] = new DefaultStandingsEveapiFormat {}
  implicit lazy val StandingsResultFormat: scalaxb.XMLFormat[eveapi.xml.corp.Standings.Result] = new DefaultStandingsResultFormat {}
  implicit lazy val StandingsCorporationNPCStandingsFormat: scalaxb.XMLFormat[eveapi.xml.corp.Standings.CorporationNPCStandings] = new DefaultStandingsCorporationNPCStandingsFormat {}
  implicit lazy val StandingsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.corp.Standings.Rowset] = new DefaultStandingsRowsetFormat {}
  implicit lazy val StandingsRowFormat: scalaxb.XMLFormat[eveapi.xml.corp.Standings.Row] = new DefaultStandingsRowFormat {}

  trait DefaultStandingsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.corp.Standings.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.corp.Standings.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.corp.Standings.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.corp.Standings.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.corp.Standings.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.corp.Standings.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.corp.Standings.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultStandingsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.corp.Standings.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.corp.Standings.Result] =
      phrase((scalaxb.ElemName(None, "corporationNPCStandings")) ^^
      { case p1 =>
      eveapi.xml.corp.Standings.Result(scalaxb.fromXML[eveapi.xml.corp.Standings.CorporationNPCStandings](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.corp.Standings.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.corp.Standings.CorporationNPCStandings](__obj.corporationNPCStandings, None, Some("corporationNPCStandings"), __scope, false))

  }

  trait DefaultStandingsCorporationNPCStandingsFormat extends scalaxb.ElemNameParser[eveapi.xml.corp.Standings.CorporationNPCStandings] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.corp.Standings.CorporationNPCStandings] =
      phrase(safeRep(scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.corp.Standings.CorporationNPCStandings(p1.toSeq map { scalaxb.fromXML[eveapi.xml.corp.Standings.Rowset](_, scalaxb.ElemName(node) :: stack) }: _*) })
    
    def writesChildNodes(__obj: eveapi.xml.corp.Standings.CorporationNPCStandings, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.rowset flatMap { scalaxb.toXML[eveapi.xml.corp.Standings.Rowset](_, None, Some("rowset"), __scope, false) })

  }

  trait DefaultStandingsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.corp.Standings.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.corp.Standings.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.corp.Standings.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.corp.Standings.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.corp.Standings.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.corp.Standings.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.corp.Standings.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultStandingsRowFormat extends scalaxb.XMLFormat[eveapi.xml.corp.Standings.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.corp.Standings.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.corp.Standings.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.corp.Standings.Row(scala.collection.immutable.ListMap(List(
        (node \ "@fromID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@fromID" -> _ },
        (node \ "@fromName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@fromName" -> _ },
        (node \ "@standing").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigDecimal](x, scalaxb.ElemName(node) :: stack)) } map { "@standing" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.corp.Standings.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@fromID", _) => attr = scala.xml.Attribute(null, "fromID", __obj.fromID.toString, attr)
        case ("@fromName", _) => attr = scala.xml.Attribute(null, "fromName", __obj.fromName.toString, attr)
        case ("@standing", _) => attr = scala.xml.Attribute(null, "standing", __obj.standing.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.corp.Standings.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}

