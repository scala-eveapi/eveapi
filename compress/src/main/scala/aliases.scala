package eveapi

import eveapi.data.crest._

package object compress {
  type CompressedCharacter = CompressedStandardIdentifier[Character]
  type CompressedShip = CompressedStandardIdentifier[Ship]
  type CompressedSolarSystem = CompressedStandardIdentifier[SolarSystem]
  type CompressedStation = CompressedStandardIdentifier[Station]
}
