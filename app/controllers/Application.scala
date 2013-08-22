package controllers

import play.api._
import play.api.mvc._
import models.FeedReader
import models.TubeStatus

object Application extends Controller {
  
  val feedReader = new Object with FeedReader
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def tubeStatus = Action {
    val statuses = TubeStatus.getStatuses(feedReader.get)
    Ok(views.html.tubestatus(statuses))
  }
  
}
