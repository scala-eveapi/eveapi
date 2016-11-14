// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package eveapi.xml.account.eve.CharacterInfo2

import scala.concurrent.Future

/**
usage:
val obj = scalaxb.fromXML[eveapi.xml.account.eve.CharacterInfo2.Foo](node)
val document = scalaxb.toXML[eveapi.xml.account.eve.CharacterInfo2.Foo](obj, "foo", eveapi.xml.account.eve.CharacterInfo2.defaultScope)
  **/
object `package` extends XMLProtocol {}

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global

  val defaultScope = scalaxb.toScope(Some("xs") -> "http://www.w3.org/2001/XMLSchema",
                                     Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val CharacterInfo2EveapiFormat: scalaxb.XMLFormat[
      eveapi.xml.account.eve.CharacterInfo2.Eveapi] = new DefaultCharacterInfo2EveapiFormat {}
  implicit lazy val CharacterInfo2ResultFormat: scalaxb.XMLFormat[
      eveapi.xml.account.eve.CharacterInfo2.Result] = new DefaultCharacterInfo2ResultFormat {}
  implicit lazy val CharacterInfo2RowsetFormat: scalaxb.XMLFormat[
      eveapi.xml.account.eve.CharacterInfo2.Rowset] = new DefaultCharacterInfo2RowsetFormat {}
  implicit lazy val CharacterInfo2RowFormat: scalaxb.XMLFormat[
      eveapi.xml.account.eve.CharacterInfo2.Row] = new DefaultCharacterInfo2RowFormat {}

  trait DefaultCharacterInfo2EveapiFormat
      extends scalaxb.ElemNameParser[eveapi.xml.account.eve.CharacterInfo2.Eveapi] {
    val targetNamespace: Option[String] = None

    def parser(
      node: scala.xml.Node,
      stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.eve.CharacterInfo2.Eveapi] =
      phrase(
          (scalaxb.ElemName(None, "currentTime")) ~
          (scalaxb.ElemName(None, "result")) ~
          (scalaxb.ElemName(None, "cachedUntil")) ^^ {
        case p1 ~ p2 ~ p3 =>
          eveapi.xml.account.eve.CharacterInfo2.Eveapi(
              scalaxb.fromXML[String](p1, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[eveapi.xml.account.eve.CharacterInfo2.Result](
                  p2, scalaxb.ElemName(node) :: stack),
              scalaxb.fromXML[String](p3, scalaxb.ElemName(node) :: stack),
              scala.collection.immutable.ListMap(List(
                      (node \ "@version").headOption map { x =>
                    scalaxb.DataRecord(
                        x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack))
                  } map { "@version" -> _ }
                  ).flatten[(String, scalaxb.DataRecord[Any])]: _*))
      })

    override def writesAttribute(__obj: eveapi.xml.account.eve.CharacterInfo2.Eveapi,
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

    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterInfo2.Eveapi,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(
          scalaxb.toXML[String](__obj.currentTime, None, Some("currentTime"), __scope, false),
          scalaxb.toXML[eveapi.xml.account.eve.CharacterInfo2.Result](
              __obj.result, None, Some("result"), __scope, false),
          scalaxb.toXML[String](__obj.cachedUntil, None, Some("cachedUntil"), __scope, false))
  }

  trait DefaultCharacterInfo2ResultFormat
      extends scalaxb.ElemNameParser[eveapi.xml.account.eve.CharacterInfo2.Result] {
    val targetNamespace: Option[String] = None

    def parser(
      node: scala.xml.Node,
      stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.eve.CharacterInfo2.Result] =
      phrase(
          (scalaxb.ElemName(None, "characterID")) ~
          (scalaxb.ElemName(None, "characterName")) ~
          (scalaxb.ElemName(None, "race")) ~
          (scalaxb.ElemName(None, "bloodlineID")) ~
          (scalaxb.ElemName(None, "bloodline")) ~
          (scalaxb.ElemName(None, "ancestryID")) ~
          (scalaxb.ElemName(None, "ancestry")) ~
          (scalaxb.ElemName(None, "corporationID")) ~
          (scalaxb.ElemName(None, "corporation")) ~
          (scalaxb.ElemName(None, "corporationDate")) ~
          (scalaxb.ElemName(None, "securityStatus")) ~
          (scalaxb.ElemName(None, "rowset")) ^^ {
        case p1 ~ p2 ~ p3 ~ p4 ~ p5 ~ p6 ~ p7 ~ p8 ~ p9 ~ p10 ~ p11 ~ p12 =>
          eveapi.xml.account.eve.CharacterInfo2.Result(scalaxb
                                                         .fromXML[BigInt](
                                                           p1, scalaxb.ElemName(node) :: stack),
                                                       scalaxb.fromXML[String](
                                                           p2, scalaxb.ElemName(node) :: stack),
                                                       scalaxb
                                                         .fromXML[String](
                                                           p3, scalaxb.ElemName(node) :: stack),
                                                       scalaxb
                                                         .fromXML[BigInt](
                                                           p4,
                                                           scalaxb.ElemName(node) :: stack),
                                                       scalaxb.fromXML[String](p5,
                                                                               scalaxb.ElemName(
                                                                                   node) :: stack),
                                                       scalaxb.fromXML[BigInt](
                                                           p6,
                                                           scalaxb.ElemName(node) :: stack),
                                                       scalaxb.fromXML[String](p7,
                                                                               scalaxb.ElemName(
                                                                                   node) :: stack),
                                                       scalaxb.fromXML[BigInt](p8,
                                                                               scalaxb.ElemName(
                                                                                   node) :: stack),
                                                       scalaxb.fromXML[String](p9,
                                                                               scalaxb.ElemName(
                                                                                   node) :: stack),
                                                       scalaxb.fromXML[String](
                                                           p10,
                                                           scalaxb.ElemName(node) :: stack),
                                                       scalaxb.fromXML[BigDecimal](p11,
                                                                                   scalaxb.ElemName(
                                                                                       node) :: stack),
                                                       scalaxb.fromXML[
                                                           eveapi.xml.account.eve.CharacterInfo2.Rowset](
                                                           p12, scalaxb.ElemName(node) :: stack))
      })

    def writesChildNodes(
      __obj: eveapi.xml.account.eve.CharacterInfo2.Result,
      __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(
          scalaxb.toXML[BigInt](
              __obj.characterID,
              None,
              Some("characterID"),
              __scope,
              false),
          scalaxb
            .toXML[String](
              __obj.characterName,
              None,
              Some("characterName"),
              __scope,
              false),
          scalaxb.toXML[String](__obj.race, None, Some("race"), __scope, false),
          scalaxb.toXML[BigInt](__obj.bloodlineID,
                                       None,
                                       Some("bloodlineID"),
                                       __scope,
                                       false),
                 scalaxb.toXML[String](__obj.bloodline, None, Some("bloodline"), __scope, false),
                 scalaxb.toXML[BigInt](__obj.ancestryID, None, Some("ancestryID"), __scope, false),
                 scalaxb.toXML[String](__obj.ancestry, None, Some("ancestry"), __scope, false),
                 scalaxb
                   .toXML[BigInt](
                     __obj.corporationID,
                     None,
                     Some("corporationID"),
                     __scope,
                     false),
                 scalaxb
                   .toXML[String](__obj.corporation, None, Some("corporation"), __scope, false),
                 scalaxb
                   .toXML[String](__obj.corporationDate, None, Some("corporationDate"), __scope, false),
                 scalaxb.toXML[BigDecimal](
                     __obj.securityStatus, None, Some("securityStatus"), __scope, false),
                 scalaxb.toXML[eveapi.xml.account.eve.CharacterInfo2.Rowset](
                     __obj.rowset, None, Some("rowset"), __scope, false))
  }

  trait DefaultCharacterInfo2RowsetFormat
      extends scalaxb.ElemNameParser[eveapi.xml.account.eve.CharacterInfo2.Rowset] {
    val targetNamespace: Option[String] = None

    def parser(
      node: scala.xml.Node,
      stack: List[scalaxb.ElemName]): Parser[eveapi.xml.account.eve.CharacterInfo2.Rowset] =
      phrase(
          safeRep(scalaxb.ElemName(None, "row")) ^^ {
        case p1 =>
          eveapi.xml.account.eve.CharacterInfo2.Rowset(p1.toSeq map {
            scalaxb.fromXML[eveapi.xml.account.eve.CharacterInfo2.Row](
                _, scalaxb.ElemName(node) :: stack)
          }, scala.collection.immutable.ListMap(List((node \ "@columns").headOption map { x =>
            scalaxb.DataRecord(
                x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
          } map { "@columns" -> _ }, (node \ "@key").headOption map { x =>
            scalaxb.DataRecord(
                x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
          } map { "@key" -> _ }, (node \ "@name").headOption map { x =>
            scalaxb.DataRecord(
                x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
          } map { "@name" -> _ }).flatten[(String, scalaxb.DataRecord[Any])]: _*))
      })

    override def writesAttribute(__obj: eveapi.xml.account.eve.CharacterInfo2.Rowset,
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

    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterInfo2.Rowset,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.row flatMap {
            scalaxb.toXML[eveapi.xml.account.eve.CharacterInfo2.Row](
                _, None, Some("row"), __scope, false)
          })
  }

  trait DefaultCharacterInfo2RowFormat
      extends scalaxb.XMLFormat[eveapi.xml.account.eve.CharacterInfo2.Row]
      with scalaxb.CanWriteChildNodes[eveapi.xml.account.eve.CharacterInfo2.Row] {
    val targetNamespace: Option[String] = None
    import scalaxb.ElemName._

    def reads(
      seq: scala.xml.NodeSeq,
      stack: List[scalaxb.ElemName]): Either[String, eveapi.xml.account.eve.CharacterInfo2.Row] =
      seq match {
        case node: scala.xml.Node =>
          Right(eveapi.xml.account.eve.CharacterInfo2.Row(scala.collection.immutable
                    .ListMap(
                      List(
                          (node \ "@corporationID").headOption map { x =>
                scalaxb.DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack))
              } map { "@corporationID" -> _ },
                          (node \ "@corporationName").headOption map { x =>
                scalaxb.DataRecord(x,
                                   node,
                                   scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
              } map { "@corporationName" -> _ },
                          (node \ "@recordID").headOption map { x =>
                scalaxb
                  .DataRecord(x, node, scalaxb.fromXML[BigInt](x, scalaxb.ElemName(node) :: stack))
              } map { "@recordID" -> _ },
                          (node \ "@startDate").headOption map { x =>
                scalaxb.DataRecord(x, node, scalaxb.fromXML[String](x, scalaxb.ElemName(node) :: stack))
              } map { "@startDate" -> _ }
                      ).flatten[(String, scalaxb.DataRecord[Any])]: _*)))
        case _ => Left("reads failed: seq must be scala.xml.Node")
      }

    override def writesAttribute(__obj: eveapi.xml.account.eve.CharacterInfo2.Row,
                                 __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case ("@corporationID", _) =>
          attr = scala.xml.Attribute(null, "corporationID", __obj.corporationID.toString, attr)
        case ("@corporationName", _) =>
          attr = scala.xml.Attribute(null, "corporationName", __obj.corporationName.toString, attr)
        case ("@recordID", _) =>
          attr = scala.xml.Attribute(null, "recordID", __obj.recordID.toString, attr)
        case ("@startDate", _) =>
          attr = scala.xml.Attribute(null, "startDate", __obj.startDate.toString, attr)
        case (key, x) =>
          attr = scala.xml.Attribute((x.namespace map { __scope.getPrefix(_) }).orNull,
                                     x.key.orNull,
                                     x.value.toString,
                                     attr)
      }
      attr
    }

    def writesChildNodes(__obj: eveapi.xml.account.eve.CharacterInfo2.Row,
                         __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil
  }
}
