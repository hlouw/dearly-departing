package models

import dispatch._, Defaults._
import xml._

trait FeedReader {
  
  protected def pull = {
    val request = url("http://cloud.tfl.gov.uk/TrackerNet/LineStatus")
    val future = Http(request OK as.String)
    future()
  }
  
  def get = {
    val raw = pull
    XML loadString raw.substring(raw indexOf '\n')
  }
}