package eveapi.utils

import org.atnos.eff._
import all._
import org.atnos.eff.syntax.eff._
import org.atnos.eff.syntax.all._
import org.atnos.eff.all._
import scala.concurrent._
import scala.concurrent.duration._
import Interpret._
import scalaz._, Scalaz._
import scalaz.concurrent.Task
import scala.util.control.NonFatal
import eveapi.errors._

import scala.concurrent.ExecutionContext.Implicits.global

object TaskEffect {
  def task[R, A](a: Task[A])(implicit m: Task <= R, d: EveApiError \/ ? <= R): Eff[R, A] =
    send[Task, R, EveApiError \/ A](a.attempt.map(_.leftMap(ThrownException.apply))).flatMap(x =>
          fromDisjunction(x))

  def innocentTask[R, A](a: Task[A])(implicit m: Task <= R): Eff[R, A] =
    send[Task, R, A](a)

  def runTask[R, U, A, B](atMost: Duration)(effects: Eff[R, A])(
    implicit m: Member.Aux[Task, R, U]): Eff[U, A] = {
    val recurse = new Recurse[Task, U, A] {
      def apply[X](m: Task[X]): X \/ Eff[U, A] =
        -\/(m.unsafePerformSyncFor(atMost))
    }
    interpret1[R, U, Task, A, A](identity)(recurse)(effects)(m)
  }
}
