package eveapi.data.evewho

case class CharacterInfo(
    character_id: String,
    corporation_id: String,
    alliance_id: String,
    faction_id: String,
    name: String,
    sec_status: String
)

case class CharacterHistory(
    corporation_id: String,
    start_date: String,
    end_date: String
)

case class CharacterData(
    info: CharacterInfo,
    history: List[CharacterHistory]
)

case class CorpInfo(
    corporation_id: String,
    name: String,
    memberCount: String
)

case class Character(
    character_id: Long,
    corporation_id: Long,
    alliance_id: Long,
    name: String
)

case class CorpData(
    info: CorpInfo,
    characters: List[Character]
)

case class AllianceInfo(
    alliance_id: String,
    name: String,
    memberCount: String
)

case class AllianceData(
    info: AllianceInfo,
    characters: List[Character]
)
