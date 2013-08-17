package model

object TubeStatus {
  def apply(node: xml.Node): TubeStatus = {
    
    val line = node \ "Line" \ "@Name"
    val status = node \ "Status" \ "@Description"
    
    new TubeStatus(line.text, status.text)
  }
  
  def getStatuses(node: xml.Elem): List[TubeStatus] = {
    (node \ "LineStatus") map (line => TubeStatus(line)) toList
  } 
}

case class TubeStatus(line: String, status: String)

