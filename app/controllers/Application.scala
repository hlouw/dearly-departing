package controllers

import play.api._
import play.api.mvc._
import models.FeedReader

object Application extends Controller {
  
  val feedReader = new Object with FeedReader
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def tubeStatus = Action {
    Ok(feedReader.get)
  }
  
}