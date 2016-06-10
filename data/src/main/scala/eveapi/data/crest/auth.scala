package eveapi.data.crest

case class CallbackResponse(access_token: String,
                            token_type: String,
                            expires_in: Long,
                            refresh_token: Option[String])

case class VerifyResponse(
    CharacterID: Long,
    CharacterName: String,
    ExpiresOn: String,
    Scopes: String,
    TokenType: String,
    CharacterOwnerHash: String,
    IntellectualProperty: String
)
