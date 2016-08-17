package eveapi.data.crest

// TODO add more
sealed trait EveException {
  def key: String
}
case class ForbiddenError(
  isLocalized: Boolean,
  key: String,
  message: String,
  title: Option[String]
)
    extends EveException
case class UnsupportedMediaTypeError(
  key: String,
  message: String
)
    extends EveException

case class UnauthorizedError(key: String, isLocalized: Boolean, message: String)
    extends EveException
case class AccessDeniedForbiddenError(key: String, isLocalized: Boolean, message: String)
    extends EveException
