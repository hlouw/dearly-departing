package controllers

import play.api._
import play.api.mvc._
import models.FeedReader
import models.TubeStatus

object Application extends Controller {
  
  val feedReader = new Object with FeedReader
  
  val username = "prometheus"
  
  def index = Action {
    Ok(views.html.index(username))
  }
  
  def tubeStatus = Action {
    val statuses = TubeStatus.getStatuses(feedReader.get)
    Ok(views.html.tubestatus(username, statuses))
  }
  
  def profile = Action {
    Ok(views.html.profile(username))
  }
}
