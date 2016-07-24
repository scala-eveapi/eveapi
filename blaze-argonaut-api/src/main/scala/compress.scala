package eveapi

import org.http4s.Uri
import org.http4s.util.CaseInsensitiveString
import eveapi.compress.PathLens
import scalaz.Reader
import compress._

object UriPathLens extends PathLens[Uri] {
  def toLink(path: String): Reader[EveServer, Uri] = Reader { server =>
    Uri(scheme = Some(CaseInsensitiveString("https")),
        authority = Some(Uri.Authority(host = Uri.RegName(server.server))),
        path = path)
  }
  def fromLink(uri: Uri) = uri.path
}
