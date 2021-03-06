// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.char.AccountBalance

import scala.concurrent.Future

/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.account.char.AccountBalance.Foo](node)
val document = scalaxb.toXML[eveapi.xml.account.char.AccountBalance.Foo](obj, "foo", eveapi.xml.account.char.AccountBalance.defaultScope)
  **/
object `package` extends XMLProtocol {}

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
                                     Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val AccountBalanceEveapiFormat: scalaxb.XMLFormat[
      eveapi.xml.account.char.AccountBalance.Eveapi] = new DefaultAccountBalanceEveapiFormat {}
  implicit lazy val AccountBalanceResultFormat: scalaxb.XMLFormat[
      eveapi.xml.account.char.AccountBalance.Result] = new DefaultAccountBalanceResultFormat {}
  implicit lazy val AccountBalanceRowsetFormat: scalaxb.XMLFormat[
      eveapi.xml.account.char.AccountBalance.Rowset] = new DefaultAccountBalanceRowsetFormat {}
  implicit lazy val AccountBalanceRowFormat: scalaxb.XMLFormat[
      eveapi.xml.account.char.AccountBalance.Row] = new DefaultAccountBalanceRowFormat {}

  trait DefaultAccountBalanceEveapiFormat
      extends scalaxb.ElemNameParser[eveapi.xml.account.char.AccountBalance.Eveapi] {
    val targetNamespace: Option[String] = None

    def parser(
      node: scala.xml.Node,
      stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.char.AccountBalance.Eveapi] =
      phrase(
          (scalaxb.ElemName(None, "currentTime")) ~
          (scalaxb.ElemName(None, "result")) ~
          (scalaxb.ElemName(None, "cachedUntil")) ^^ {
        case p1 ~ p2 ~ p3 =>
          eveapi.xml.account.char.AccountBalance.Eveapi(
              scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[eveapi.xml.account.char.AccountBalance.Result](
                  p2, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
              scala.collection.immutable.ListMap(List(
                      (node \ "@version").headOption map { x =>
                    scalaxb.DataRecord(
                        x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack))
                  } map { "@version" -> _ }
                  ).flatten[(String, scalaxb.DataRecord[Any])]: _*))
      })

    override def writesAttribute(__obj: eveapi.xml.account.char.AccountBalance.Eveapi,
                                 __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case ("@version", _) =>
          attr = scala.xml.Attribute(null, "version", __obj.version.toString, attr)
        case (key, x) =>
          attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull,
                                     x.key.orNull,
                                     x.value.toString,
                                     attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.char.AccountBalance.Eveapi,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(
          scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
          scalaxb.toXML[eveapi.xml.account.char.AccountBalance.Result](
              __obj.result, None, Some("result"), __scope, false),
          scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))
  }

  trait DefaultAccountBalanceResultFormat
      extends scalaxb.ElemNameParser[eveapi.xml.account.char.AccountBalance.Result] {
    val targetNamespace: Option[String] = None

    def parser(
      node: scala.xml.Node,
      stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.char.AccountBalance.Result] =
      phrase(
          (scalaxb.ElemName(None, "rowset")) ^^ {
        case p1 =>
          eveapi.xml.account.char.AccountBalance
            .Result(scalaxb.fromXML[eveapi.xml.account.char.AccountBalance.Rowset](
                  p1, scalaxb.ElemName(node) :: stack))
      })

    def writesChildNodes(__obj: eveapi.xml.account.char.AccountBalance.Result,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.account.char.AccountBalance.Rowset](
          __obj.rowset, None, Some("rowset"), __scope, false))
  }

  trait DefaultAccountBalanceRowsetFormat
      extends scalaxb.ElemNameParser[eveapi.xml.account.char.AccountBalance.Rowset] {
    val targetNamespace: Option[String] = None

    def parser(
      node: scala.xml.Node,
      stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.char.AccountBalance.Rowset] =
      phrase(
          (scalaxb.ElemName(None, "row")) ^^ {
        case p1 =>
          eveapi.xml.account.char.AccountBalance.Rowset(
              scalaxb.fromXML[eveapi.xml.account.char.AccountBalance.Row](
                  p1, scalaxb.ElemName(node) :: stack),
              scala.collection.immutable.ListMap(List(
                      (node \ "@columns").headOption map { x =>
                    scalaxb.DataRecord(
                        x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
                  } map { "@columns" -> _ },
                      (node \ "@key").headOption map { x =>
                    scalaxb.DataRecord(
                        x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
                  } map { "@key" -> _ },
                      (node \ "@name").headOption map { x =>
                    scalaxb.DataRecord(
                        x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
                  } map { "@name" -> _ }
                  ).flatten[(String, scalaxb.DataRecord[Any])]: _*))
      })

    override def writesAttribute(__obj: eveapi.xml.account.char.AccountBalance.Rowset,
                                 __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case ("@columns", _) =>
          attr = scala.xml.Attribute(null, "columns", __obj.columns.toString, attr)
        case ("@key", _) => attr = scala.xml.Attribute(null, "key", __obj.key.toString, attr)
        case ("@name", _) => attr = scala.xml.Attribute(null, "name", __obj.name.toString, attr)
        case (key, x) =>
          attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull,
                                     x.key.orNull,
                                     x.value.toString,
                                     attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.char.AccountBalance.Rowset,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (scalaxb.toXML[eveapi.xml.account.char.AccountBalance.Row](
          __obj.row, None, Some("row"), __scope, false))
  }

  trait DefaultAccountBalanceRowFormat
      extends scalaxb.XMLFormat[eveapi.xml.account.char.AccountBalance.Row]
      with scalaxb.CanWriteChildNodes[eveapi.xml.account.char.AccountBalance.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._

    def reads(
      seq: scala.xml.NodeSeq,
      stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.account.char.AccountBalance.Row] =
      seq match {
        case node: scala.xml.Node =>
          Right(
              eveapi.xml.account.char.AccountBalance.Row(scala.collection.immutable.ListMap(List(
                          (node \ "@accountID").headOption map { x =>
                scalaxb.DataRecord(x,
                                   node,
                                   scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack))
              } map { "@accountID" -> _ },
                          (node \ "@accountKey").headOption map { x =>
                scalaxb.DataRecord(
                    x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack))
              } map { "@accountKey" -> _ },
                          (node \ "@balance").headOption map { x =>
                scalaxb.DataRecord(
                    x, node, scalaxb.fromXML[BigDecimal](x, scalaxb.ElemName(node) :: stack))
              } map { "@balance" -> _ }
                      ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
        case _ => Left("reads failed: seq must be scala.xml.Node")
      }

    override def writesAttribute(__obj: eveapi.xml.account.char.AccountBalance.Row,
                                 __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case ("@accountID", _) =>
          attr = scala.xml.Attribute(null, "accountID", __obj.accountID.toString, attr)
        case ("@accountKey", _) =>
          attr = scala.xml.Attribute(null, "accountKey", __obj.accountKey.toString, attr)
        case ("@balance", _) =>
          attr = scala.xml.Attribute(null, "balance", __obj.balance.toString, attr)
        case (key, x) =>
          attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull,
                                     x.key.orNull,
                                     x.value.toString,
                                     attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.char.AccountBalance.Row,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil
  }
}
