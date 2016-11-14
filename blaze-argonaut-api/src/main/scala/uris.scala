package eveapi
import org.http4s._
import eveapi.xml.account._

case class XMLLink[T](href: Uri)

object uri {
  val AccountBalance = XMLLink[char.AccountBalance.Eveapi](
      Uri.uri("https://api.eveonline.com/char/AccountBalance.xml.aspx"))
  val AssetList =
    XMLLink[char.AssetList.Eveapi](Uri.uri("https://api.eveonline.com/char/AssetList.xml.aspx"))
  val Blueprints =
    XMLLink[char.Blueprints.Eveapi](Uri.uri("https://api.eveonline.com/char/Blueprints.xml.aspx"))
  val CharacterInfo = XMLLink[char.CharacterInfo.Eveapi](
      Uri.uri("https://api.eveonline.com/char/CharacterSheet.xml.aspx"))
  val ContractItems = XMLLink[char.ContractItems.Eveapi](
      Uri.uri("https://api.eveonline.com/char/ContractItems.xml.aspx"))
  val Contracts =
    XMLLink[char.Contracts.Eveapi](Uri.uri("https://api.eveonline.com/char/Contracts.xml.aspx"))
  val KillMails =
    XMLLink[char.KillMails.Eveapi](Uri.uri("https://api.eveonline.com/char/KillMails.xml.aspx"))
  val MailBodies =
    XMLLink[char.MailBodies.Eveapi](Uri.uri("https://api.eveonline.com/char/MailBodies.xml.aspx"))
  val MarketOrder = XMLLink[char.MarketOrder.Eveapi](
      Uri.uri("https://api.eveonline.com/char/MarketOrder.xml.aspx"))
  val Medals =
    XMLLink[char.Medals.Eveapi](Uri.uri("https://api.eveonline.com/char/Medals.xml.aspx"))
  val Notifications = XMLLink[char.Notifications.Eveapi](
      Uri.uri("https://api.eveonline.com/char/Notifications.xml.aspx"))
  val NotificationTexts = XMLLink[char.NotificationTexts.Eveapi](
      Uri.uri("https://api.eveonline.com/char/NotificationTexts.xml.aspx"))
  val SkillInTraining = XMLLink[char.SkillInTraining.Eveapi](
      Uri.uri("https://api.eveonline.com/char/SkillInTraining.xml.aspx"))
  val SkillQueue =
    XMLLink[char.SkillQueue.Eveapi](Uri.uri("https://api.eveonline.com/char/SkillQueue.xml.aspx"))
  val Standings =
    XMLLink[char.Standings.Eveapi](Uri.uri("https://api.eveonline.com/char/Standings.xml.aspx"))
  val UpcomingCalendarEvents = XMLLink[char.UpcomingCalendarEvents.Eveapi](
      Uri.uri("https://api.eveonline.com/char/UpcomningCalendarEvents.xml.aspx"))
  val WalletJournal = XMLLink[char.WalletJournal.Eveapi](
      Uri.uri("https://api.eveonline.com/char/WalletJournal.xml.aspx"))
  val WalletTransactions = XMLLink[char.WalletTransactions.Eveapi](
      Uri.uri("https://api.eveonline.com/char/WalletTransactions.xml.aspx"))
  val Skills =
    XMLLink[char.Skills.Eveapi](Uri.uri("https://api.eveonline.com/char/Skills.xml.aspx"))
}
