import sbt._

object Dependencies {
  val scalatest = "org.scalatest" %% "scalatest" % "3.0.4"
  val mockitoScala = "org.markushauck" %% "mockitoscala" % "0.3.0"
  val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.13.5"

  val typesafeConfig = "com.typesafe" % "config" % "1.3.3"
  val pureConfig = "com.github.pureconfig" %% "pureconfig" % "0.9.0"

  val grizzledLogging = "org.clapper" %% "grizzled-slf4j" % "1.3.2"
  val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"

  val circe: Seq[ModuleID] = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % "0.9.1")

  val betterFiles = "com.github.pathikrit" %% "better-files" % "3.4.0"

  val gatlingVersion = "2.3.0"
  val gatlingHighcharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion
  val gatlingTestFramework = "io.gatling" % "gatling-test-framework" % gatlingVersion

  val monocleVersion = "1.5.0"
  val monocleCore = "com.github.julien-truffaut" %% "monocle-core" % monocleVersion
  val monocleMacro = "com.github.julien-truffaut" %% "monocle-macro" % monocleVersion
}