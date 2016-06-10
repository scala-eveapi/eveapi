// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.char.WalletTransactions

import scala.concurrent.Future


/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.char.WalletTransactions.Foo](node)
val document = scalaxb.toXML[eveapi.xml.char.WalletTransactions.Foo](obj, "foo", eveapi.xml.char.WalletTransactions.defaultScope)
**/
object `package` extends XMLProtocol { }

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val WalletTransactionsEveapiFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletTransactions.Eveapi] = new DefaultWalletTransactionsEveapiFormat {}
  implicit lazy val WalletTransactionsResultFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletTransactions.Result] = new DefaultWalletTransactionsResultFormat {}
  implicit lazy val WalletTransactionsRowsetFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletTransactions.Rowset] = new DefaultWalletTransactionsRowsetFormat {}
  implicit lazy val WalletTransactionsRowFormat: scalaxb.XMLFormat[eveapi.xml.char.WalletTransactions.Row] = new DefaultWalletTransactionsRowFormat {}

  trait DefaultWalletTransactionsEveapiFormat extends scalaxb.ElemNameParser[eveapi.xml.char.WalletTransactions.Eveapi] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.WalletTransactions.Eveapi] =
      phrase((scalaxb.ElemName(None, "currentTime")) ~ 
      (scalaxb.ElemName(None, "result")) ~ 
      (scalaxb.ElemName(None, "cachedUntil")) ^^
      { case p1 ~ p2 ~ p3 =>
      eveapi.xml.char.WalletTransactions.Eveapi(scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[eveapi.xml.char.WalletTransactions.Result](p2, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
        scala.collection.immutable.ListMap(List(
        (node \ "@version").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@version" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.WalletTransactions.Eveapi, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) => attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.WalletTransactions.Eveapi, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
        scalaxb.toXML[eveapi.xml.char.WalletTransactions.Result](__obj.result, None, Some("result"), __scope, false),
        scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))

  }

  trait DefaultWalletTransactionsResultFormat extends scalaxb.ElemNameParser[eveapi.xml.char.WalletTransactions.Result] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.WalletTransactions.Result] =
      phrase((scalaxb.ElemName(None, "rowset")) ^^
      { case p1 =>
      eveapi.xml.char.WalletTransactions.Result(scalaxb.fromXML[eveapi.xml.char.WalletTransactions.Rowset](p1, scalaxb.ElemName(node) :: stack)) })
    
    def writesChildNodes(__obj: eveapi.xml.char.WalletTransactions.Result, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.char.WalletTransactions.Rowset](__obj.rowset, None, Some("rowset"), __scope, false))

  }

  trait DefaultWalletTransactionsRowsetFormat extends scalaxb.ElemNameParser[eveapi.xml.char.WalletTransactions.Rowset] {
    val targetNamespace: Option[String] = None
    
    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[eveapi.xml.char.WalletTransactions.Rowset] =
      phrase(safeRep(scalaxb.ElemName(None, "row")) ^^
      { case p1 =>
      eveapi.xml.char.WalletTransactions.Rowset(p1.toSeq map { scalaxb.fromXML[eveapi.xml.char.WalletTransactions.Row](_, scalaxb.ElemName(node) :: stack) },
        scala.collection.immutable.ListMap(List(
        (node \ "@columns").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@columns" -> _ },
        (node \ "@key").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@key" -> _ },
        (node \ "@name").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@name" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)) })
    
    override def writesAttribute(__obj: eveapi.xml.char.WalletTransactions.Rowset, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) => attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.WalletTransactions.Rowset, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap { scalaxb.toXML[eveapi.xml.char.WalletTransactions.Row](_, None, Some("row"), __scope, false) })

  }

  trait DefaultWalletTransactionsRowFormat extends scalaxb.XMLFormat[eveapi.xml.char.WalletTransactions.Row] with scalaxb.CanWriteChildNodes[eveapi.xml.char.WalletTransactions.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._
    
    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.char.WalletTransactions.Row] = seq match {
      case node: scala.xml.Node => Right(eveapi.xml.char.WalletTransactions.Row(scala.collection.immutable.ListMap(List(
        (node \ "@clientID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@clientID" -> _ },
        (node \ "@clientName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@clientName" -> _ },
        (node \ "@clientTypeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@clientTypeID" -> _ },
        (node \ "@journalTransactionID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@journalTransactionID" -> _ },
        (node \ "@price").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigDecimal](x, scalaxb.ElemName(node) :: stack)) } map { "@price" -> _ },
        (node \ "@quantity").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@quantity" -> _ },
        (node \ "@stationID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@stationID" -> _ },
        (node \ "@stationName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@stationName" -> _ },
        (node \ "@transactionDateTime").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@transactionDateTime" -> _ },
        (node \ "@transactionFor").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@transactionFor" -> _ },
        (node \ "@transactionID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@transactionID" -> _ },
        (node \ "@transactionType").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@transactionType" -> _ },
        (node \ "@typeID").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack)) } map { "@typeID" -> _ },
        (node \ "@typeName").headOption map { x => scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack)) } map { "@typeName" -> _ }
        ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }
    
    override def writesAttribute(__obj: eveapi.xml.char.WalletTransactions.Row, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData  = scala.xml.Null
      __obj.attributes.toList map {
        case ("@clientID", _) => attr = scala.xml.Attribute(null, "clientID", __obj.clientID.toString, attr)
        case ("@clientName", _) => attr = scala.xml.Attribute(null, "clientName", __obj.clientName.toString, attr)
        case ("@clientTypeID", _) => attr = scala.xml.Attribute(null, "clientTypeID", __obj.clientTypeID.toString, attr)
        case ("@journalTransactionID", _) => attr = scala.xml.Attribute(null, "journalTransactionID", __obj.journalTransactionID.toString, attr)
        case ("@price", _) => attr = scala.xml.Attribute(null, "price", __obj.price.toString, attr)
        case ("@quantity", _) => attr = scala.xml.Attribute(null, "quantity", __obj.quantity.toString, attr)
        case ("@stationID", _) => attr = scala.xml.Attribute(null, "stationID", __obj.stationID.toString, attr)
        case ("@stationName", _) => attr = scala.xml.Attribute(null, "stationName", __obj.stationName.toString, attr)
        case ("@transactionDateTime", _) => attr = scala.xml.Attribute(null, "transactionDateTime", __obj.transactionDateTime.toString, attr)
        case ("@transactionFor", _) => attr = scala.xml.Attribute(null, "transactionFor", __obj.transactionFor.toString, attr)
        case ("@transactionID", _) => attr = scala.xml.Attribute(null, "transactionID", __obj.transactionID.toString, attr)
        case ("@transactionType", _) => attr = scala.xml.Attribute(null, "transactionType", __obj.transactionType.toString, attr)
        case ("@typeID", _) => attr = scala.xml.Attribute(null, "typeID", __obj.typeID.toString, attr)
        case ("@typeName", _) => attr = scala.xml.Attribute(null, "typeName", __obj.typeName.toString, attr)
        case (key, x) => attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.char.WalletTransactions.Row, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }


}
