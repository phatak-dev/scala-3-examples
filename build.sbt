ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.1"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaThreeExperiments",
    idePackagePrefix := Some("com.madhukaraphatak")
  )

scalacOptions ++=Seq(
  "-no-indent"
)
