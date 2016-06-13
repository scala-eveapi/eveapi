package eveapi.xml.client

import org.joda.time.DateTime

case class XMLApiResponse[T](currentTime: DateTime, cachedUntil: DateTime, result: T)
