import Dependencies._

ThisBuild / organization := "karazin-scala-users-group"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.1"

lazy val root = project
  .in(file("."))
  .settings(name := "scala-course-2022-spring")
  .settings(commonSettings: _*)

lazy val commonSettings = Seq(
  crossScalaVersions := Seq("2.13", "3.0.0", "3.1.1"),
  libraryDependencies ++= dependencies,
  testFrameworks += new TestFramework("munit.Framework"),
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-Xfatal-warnings",
  ),
  javacOptions ++= Seq(
    "-source", "11",
    "-target", "11"
  ),
)

lazy val dependencies =
  cats ++
    `cats-effect` ++
    munit
