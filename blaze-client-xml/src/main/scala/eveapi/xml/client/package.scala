package eveapi.xml

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

package object client {

  /**
   * Add a .toDateTime to strings so we can parse XML API style timestamps
   * @param s
   */
  implicit class XmlDate(s: String) {
    def toDateTime = {
      DateTime.parse(s, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"))
    }

  }
}
