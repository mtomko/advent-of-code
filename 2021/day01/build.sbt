ThisBuild / scalaVersion := "2.13.7"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.mtomko"
ThisBuild / organizationName := "mtomko"

lazy val day01 = (project in file("."))
  .settings(
    name := "day01",
    libraryDependencies ++= List(
      "co.fs2" %% "fs2-core" % "3.2.0",
      "co.fs2" %% "fs2-io" % "3.2.0",
      "org.typelevel" %% "cats-effect" % "3.3.0"
    )
  )
