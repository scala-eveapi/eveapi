package eveapi

import org.http4s.Uri
import eveapi.compress.PathLens
import scalaz.Reader
import compress._
import org.http4s.util.CaseInsensitiveString.ToCaseInsensitiveStringSyntax

object UriPathLens extends PathLens[Uri] {
  def toLink(path: String): Reader[EveServer, Uri] = Reader { server =>
    Uri(scheme = Some("https".ci),
        authority = Some(Uri.Authority(host = Uri.RegName(server.server))),
        path = path)
  }
  def fromLink(uri: Uri) = uri.path
}
