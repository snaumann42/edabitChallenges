ThisBuild / version := "0.1.0-SNAPSHOT"

//ThisBuild / scalaVersion := "3.3.1"
ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "naumann.scalaSolutions"
  )

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.2.17",
  "org.scalatest" %% "scalatest" % "3.2.17" % Test,
  "com.chuusai" %% "shapeless" % "2.3.10"
)

resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"
