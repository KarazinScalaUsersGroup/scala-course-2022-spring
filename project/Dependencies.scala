import sbt._

object Dependencies {
  
  object Version {
    val cats          = "2.7.0"
    val `cats-effect` = "3.3.8"
    val munit         = "1.0.0-M3"
  }

  lazy val cats: Seq[ModuleID] = Seq(
    "org.typelevel" %% "cats-kernel",
    "org.typelevel" %% "cats-core",
    "org.typelevel" %% "cats-laws"
  ).map(_ % Version.cats)

  lazy val `cats-effect`: Seq[ModuleID] = Seq(
    "org.typelevel" %% "cats-effect"
  ).map(_ % Version.`cats-effect` withSources() withJavadoc())
  
  lazy val munit: Seq[ModuleID] = Seq(
    "org.scalameta" %% "munit",
    "org.scalameta" %% "munit-scalacheck"
  ).map(_ % Version.munit % Test withSources() withJavadoc())

}
