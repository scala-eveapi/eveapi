// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.WalletJournal

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.char.WalletJournal.Foo](node)
val document = scalaxb.toXML[eveapi.xml.char.WalletJournal.Foo](obj, "foo", eveapi.xml.char.WalletJournal.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val WalletJournalEveapiFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletJournal.Eveapi] = new DefaultWalletJournalEveapiFormat {}
  implicit lazy val WalletJournalResultFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletJournal.Result] = new DefaultWalletJournalResultFormat {}
  implicit lazy val WalletJournalRowsetFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletJournal.Rowset] = new DefaultWalletJournalRowsetFormat {}
  implicit lazy val WalletJournalRowFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletJournal.Row] = new DefaultWalletJournalRowFormat {}

  trait DefaultWalletJournalEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.char.WalletJournal.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.WalletJournal.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.char.WalletJournal.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.char.WalletJournal.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.WalletJournal.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.WalletJournal.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.char.WalletJournal.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultWalletJournalResultFormat extends scalaxb.ElemNameParser[eveapi.xml.char.WalletJournal.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.WalletJournal.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.char.WalletJournal.Result(scalaxb.fromXML[eveapi.xml.char.WalletJournal.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.char.WalletJournal.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.char.WalletJournal.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultWalletJournalRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.char.WalletJournal.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.WalletJournal.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.char.WalletJournal.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.char.WalletJournal.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.WalletJournal.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.WalletJournal.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.char.WalletJournal.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultWalletJournalRowFormat extends scalaxb.XMLFormat[eveapi.xml.char.WalletJournal.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.char.WalletJournal.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.char.WalletJournal.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.char.WalletJournal.Row(scala.collection.immutable.ListMap(List(
        (node \ "@amount").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigDecimal](x, scalaxb.ElemName(node) :: stack)) } map { "@amount" -> _ },
        (node \ "@argID1").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@argID1" -> _ },
        (node \ "@argName1").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@argName1" -> _ },
        (node \ "@balance").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigDecimal](x, scalaxb.ElemName(node) :: stack)) } map { "@balance" -> _ },
        (node \ "@date").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@date" -> _ },
        (node \ "@owner1TypeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@owner1TypeID" -> _ },
        (node \ "@owner2TypeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@owner2TypeID" -> _ },
        (node \ "@ownerID1").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@ownerID1" -> _ },
        (node \ "@ownerID2").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@ownerID2" -> _ },
        (node \ "@ownerName1").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@ownerName1" -> _ },
        (node \ "@ownerName2").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@ownerName2" -> _ },
        (node \ "@reason").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@reason" -> _ },
        (node \ "@refID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@refID" -> _ },
        (node \ "@refTypeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@refTypeID" -> _ },
        (node \ "@taxAmount").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@taxAmount" -> _ },
        (node \ "@taxReceiverID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@taxReceiverID" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.char.WalletJournal.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@amount", _) => attr = scala.xml.Attribute(null, "amount", __obj.amount.toString, attr)
        case ("@argID1", _) => attr = scala.xml.Attribute(null, "argID1", __obj.argID1.toString, attr)
        case ("@argName1", _) => attr = scala.xml.Attribute(null, "argName1", __obj.argName1.toString, attr)
        case ("@balance", _) => attr = scala.xml.Attribute(null, "balance", __obj.balance.toString, attr)
        case ("@date", _) => attr = scala.xml.Attribute(null, "date", __obj.date.toString, attr)
        case ("@owner1TypeID", _) => attr = scala.xml.Attribute(null, "owner1TypeID", __obj.owner1TypeID.toString, attr)
        case ("@owner2TypeID", _) => attr = scala.xml.Attribute(null, "owner2TypeID", __obj.owner2TypeID.toString, attr)
        case ("@ownerID1", _) => attr = scala.xml.Attribute(null, "ownerID1", __obj.ownerID1.toString, attr)
        case ("@ownerID2", _) => attr = scala.xml.Attribute(null, "ownerID2", __obj.ownerID2.toString, attr)
        case ("@ownerName1", _) => attr = scala.xml.Attribute(null, "ownerName1", __obj.ownerName1.toString, attr)
        case ("@ownerName2", _) => attr = scala.xml.Attribute(null, "ownerName2", __obj.ownerName2.toString, attr)
        case ("@reason", _) => attr = scala.xml.Attribute(null, "reason", __obj.reason.toString, attr)
        case ("@refID", _) => attr = scala.xml.Attribute(null, "refID", __obj.refID.toString, attr)
        case ("@refTypeID", _) => attr = scala.xml.Attribute(null, "refTypeID", __obj.refTypeID.toString, attr)
        case ("@taxAmount", _) => attr = scala.xml.Attribute(null, "taxAmount", __obj.taxAmount.toString, attr)
        case ("@taxReceiverID", _) => attr = scala.xml.Attribute(null, "taxReceiverID", __obj.taxReceiverID.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.WalletJournal.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}
