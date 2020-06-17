organization := "io.github.michalw"
name := "dockerized-gatling-tests-example"
scalaVersion := "2.12.10"

enablePlugins(GatlingPlugin, DockerPlugin, JavaAppPackaging)

libraryDependencies ++= commonDependencies ++ testDependencies

packageName in Docker := "io/github/michalw/utilities/dockerized-gatling-tests-example"
dockerUpdateLatest := true

val gatlingVersion = "3.3.1"
val scalaTestVersion = "3.0.5"

lazy val commonDependencies =
  Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion
  )

lazy val testDependencies =
  Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
  )

lazy val settings =
  commonSettings ++
    scalafmtSettings

lazy val compilerOptions =
  Seq(
    "-unchecked",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-deprecation",
    "-encoding",
    "utf8"
  )

lazy val commonSettings =
  Seq(
    scalacOptions ++= compilerOptions,
    publishMavenStyle := true,
    parallelExecution in Test := false
  )

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
    scalafmtTestOnCompile := true,
    scalafmtVersion := "1.2.0"
  )
