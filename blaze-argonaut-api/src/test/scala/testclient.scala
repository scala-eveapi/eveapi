import org.http4s._
import org.http4s.client._
import scalaz.concurrent.Task

object TestClient {
  def apply(service: Service[Request, Response]) =
    Client(
        service.map(resp => DisposableResponse(resp, Task(()))),
        Task(())
    )
}
