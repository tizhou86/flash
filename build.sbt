import sbt._

lazy val flash = project.in(file(".")).aggregate(core, client, server)

lazy val core = project

lazy val client = project

lazy val server = project
