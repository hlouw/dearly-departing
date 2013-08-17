import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "dearly-departing"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
