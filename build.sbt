import sbt._
import Keys._

libraryDependencies in ThisBuild ++= Seq(
  "com.typesafe.akka" % "akka-http-experimental_2.10" % "1.0-M2" withSources(),
  "com.typesafe.akka" % "akka-http-core-experimental_2.10" % "1.0-M2" withSources(),
  "com.typesafe.akka" % "akka-stream-experimental_2.10" % "1.0-M2" withSources()
)

lazy val flash = project.in(file(".")).aggregate(core, client, server)

lazy val core = project

lazy val client = project

lazy val server = project
