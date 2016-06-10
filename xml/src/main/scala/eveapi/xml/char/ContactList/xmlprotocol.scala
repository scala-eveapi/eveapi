// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.ContactList

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.char.ContactList.Foo](node)
val document = scalaxb.toXML[eveapi.xml.char.ContactList.Foo](obj, "foo", eveapi.xml.char.ContactList.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val ContactListEveapiFormat: scalaxb.XMLFormat[eveapi.xml.char.ContactList.Eveapi] = new DefaultContactListEveapiFormat {}
  implicit lazy val ContactListResultFormat: scalaxb.XMLFormat[eveapi.xml.char.ContactList.Result] = new DefaultContactListResultFormat {}
  implicit lazy val ContactListRowsetFormat: scalaxb.XMLFormat[eveapi.xml.char.ContactList.Rowset] = new DefaultContactListRowsetFormat {}
  implicit lazy val ContactListRowFormat: scalaxb.XMLFormat[eveapi.xml.char.ContactList.Row] = new DefaultContactListRowFormat {}

  trait DefaultContactListEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.char.ContactList.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.ContactList.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.char.ContactList.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.char.ContactList.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.ContactList.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.ContactList.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.char.ContactList.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultContactListResultFormat extends scalaxb.ElemNameParser[eveapi.xml.char.ContactList.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.ContactList.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.char.ContactList.Result(scalaxb.fromXML[eveapi.xml.char.ContactList.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.char.ContactList.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.char.ContactList.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultContactListRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.char.ContactList.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.ContactList.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.char.ContactList.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.char.ContactList.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.ContactList.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.ContactList.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.char.ContactList.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultContactListRowFormat extends scalaxb.XMLFormat[eveapi.xml.char.ContactList.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.char.ContactList.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.char.ContactList.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.char.ContactList.Row(scala.collection.immutable.ListMap(List(
        (node \ "@contactID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@contactID" -> _ },
        (node \ "@contactName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@contactName" -> _ },
        (node \ "@contactTypeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@contactTypeID" -> _ },
        (node \ "@inWatchlist").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@inWatchlist" -> _ },
        (node \ "@standing").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@standing" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.char.ContactList.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@contactID", _) => attr = scala.xml.Attribute(null, "contactID", __obj.contactID.toString, attr)
        case ("@contactName", _) => attr = scala.xml.Attribute(null, "contactName", __obj.contactName.toString, attr)
        case ("@contactTypeID", _) => attr = scala.xml.Attribute(null, "contactTypeID", __obj.contactTypeID.toString, attr)
        case ("@inWatchlist", _) => __obj.inWatchlist foreach { x => attr = scala.xml.Attribute(null, "inWatchlist", x.toString, attr) }
        case ("@standing", _) => attr = scala.xml.Attribute(null, "standing", __obj.standing.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.ContactList.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}

