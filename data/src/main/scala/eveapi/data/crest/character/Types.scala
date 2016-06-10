package eveapi.data.crest.character

case class Href(
    href: String
)

case class HrefWithId(
    href: String,
    id: Long,
    id_str: String
)

case class Portrait(
    `32x32`: Href,
    `64x64`: Href,
    `128x128`: Href,
    `256x256`: Href
)

case class Corporation(
    name: String,
    isNPC: Boolean,
    href: String,
    id_str: String,
    logo: Portrait,
    id: Long
)

case class Character(
    standings: Href,
    bloodLine: HrefWithId,
    gender_str: String,
    waypoints: Href,
    channels: Href,
    href: String,
    accounts: Href,
    portrait: Portrait,
    id: Long,
    fittings: Href,
    contacts: Href,
    corporation: Corporation,
    location: Href,
    mail: Href,
    description: String,
    notifications: Href,
    id_str: String,
    name: String,
    gender: Long,
    race: HrefWithId
)
