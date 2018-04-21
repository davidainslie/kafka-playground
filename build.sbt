import com.scalapenos.sbt.prompt.SbtPrompt.autoImport._
import Dependencies._

lazy val `kafka-playground` = project.in(file(".")).enablePlugins(AutomateHeaderPlugin, GatlingPlugin, DockerPlugin, DockerComposePlugin)
  .configs(IntegrationTest, GatlingIt)
  .settings(Defaults.itSettings: _*)
  .settings(inConfig(IntegrationTest)(Defaults.testSettings): _*)
  .settings(
    organization := "com.backwards",
    organizationName := "Backwards Limited",
    startYear := Some(2018),
    licenses += ("MIT", url("https://opensource.org/licenses/MIT")),
    promptTheme := com.scalapenos.sbt.prompt.PromptThemes.ScalapenosTheme,
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      // "-target:jvm-10",
      "-encoding", "UTF-8",
      "-Ypartial-unification",
      "-Ywarn-unused-import"
    ),
    dockerImageCreationTask := docker.value,
    scalafmtOnCompile := true,
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    wartremoverWarnings in (Compile, compile) ++= Warts.unsafe,
    libraryDependencies ++= Seq(
      scalatest % Test,
      mockitoScala % Test,
      scalaCheck % Test,
    ),
    libraryDependencies ++= Seq(
      gatlingHighcharts % IntegrationTest,
      gatlingTestFramework % IntegrationTest,
    ),
    libraryDependencies ++= Seq(
      typesafeConfig,
      pureConfig,
      grizzledLogging,
      logback,
      betterFiles,
      monocleCore,
      monocleMacro
    ) ++ circe
  )

fork in run := true

fork in Test := true

fork in IntegrationTest := true

dockerfile in docker := {
  // The assembly task generates a fat JAR file
  val artifact: File = assembly.value
  val artifactTargetPath = s"/app/${artifact.name}"

  new Dockerfile {
    from("hseeberger/scala-sbt")
    env("SCALA_VERSION", "2.12.5")
    env("SBT_VERSION", "1.1.4")
    add(artifact, artifactTargetPath)
    entryPoint("java", "-Xms1024m", "-Xmx2048m", "-jar", artifactTargetPath)
  }
}