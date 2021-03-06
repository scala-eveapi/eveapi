organization in ThisBuild := "eveapi"
name := "eveapi"
scalaVersion in ThisBuild := "2.11.8"
scalafmtConfig in ThisBuild := Some((baseDirectory in root).value / ".scalafmt")
bintrayVcsUrl in ThisBuild := Some("git@github.com:scala-eveapi/eveapi.git")
licenses in ThisBuild += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayReleaseOnPublish in ThisBuild := true
publishTo in ThisBuild := Some(Resolver.bintrayRepo("andimiller", "maven"))
resolvers in ThisBuild ++= Seq(
    Resolver.sonatypeRepo("releases")
  , Resolver.sonatypeRepo("snapshots")
)
libraryDependencies in ThisBuild += "com.github.alexarchambault" %% "scalacheck-shapeless_1.13" % "1.1.0-RC1" % Test

val globalSettings =
  reformatOnCompileSettings ++
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.7.1") ++ Seq(
      scalacOptions ++= Seq(
        "-deprecation",
        "-feature",
        "-unchecked",
        "-Xlint",
        "-Ywarn-adapted-args",
        "-Ywarn-dead-code",
        "-Ywarn-inaccessible",
        "-Ywarn-nullary-override",
        "-Ywarn-numeric-widen",
        "-language:implicitConversions",
        "-language:higherKinds",
        "-language:existentials",
        "-encoding", "utf8",
        "-Xelide-below", annotation.elidable.ALL.toString
      )
    )

lazy val http4sVersion = "0.14.2a"

lazy val root = file(".")
lazy val data = (project in file("data")).settings(globalSettings)
lazy val compress = (project in file("compress")).settings(globalSettings).settings(
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.2.4"
    , "com.chuusai" %% "shapeless" % "2.3.1"
  )
).dependsOn(data)
lazy val xml = (project in file("xml")).settings(globalSettings).settings(
  libraryDependencies ++= Seq(
      "org.scala-lang.modules"       %% "scala-xml"                % "1.0.3"
    , "org.scala-lang.modules"       %% "scala-parser-combinators" % "1.0.3"
  )
)

lazy val argonautCodecs = (project in file("argonaut")).settings(globalSettings).settings(
  libraryDependencies ++= Seq(
    "io.argonaut" %% "argonaut" % "6.1a",
    "com.github.alexarchambault" %% "argonaut-shapeless_6.2" % "1.2.0-M4"
  ),
  dependencyOverrides += "io.argonaut" %% "argonaut" % "6.1a"
).dependsOn(data)
lazy val circeCodecs = (project in file("circe")).settings(globalSettings).settings(
  libraryDependencies ++= Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % "0.4.1")
).dependsOn(data)

lazy val blazeArgonautApi = (project in file("blaze-argonaut-api")).settings(globalSettings).settings(
  libraryDependencies ++= Seq(
      "org.atnos" %% "eff-scalaz" % "2.0.0-RC7"
    , "commons-codec" % "commons-codec" % "1.10"
    , "org.http4s" %% "http4s-blaze-server" % http4sVersion
    , "org.http4s" %% "http4s-dsl" % http4sVersion
    , "org.http4s" %% "http4s-argonaut" % http4sVersion
    , "org.http4s" %% "http4s-blaze-client" % http4sVersion
    , "ch.qos.logback" %  "logback-classic" % "1.1.7"
  ),
  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.7.1"),
  addCompilerPlugin("com.milessabin" % "si2712fix-plugin_2.11.8" % "1.1.0")
).dependsOn(data, argonautCodecs, compress, xml)

lazy val yolo = (project in file("yolo")).settings(globalSettings).dependsOn(blazeArgonautApi, argonautCodecs).settings(
    addCompilerPlugin("com.milessabin" % "si2712fix-plugin_2.11.8" % "1.1.0")
  , initialCommands in console := """
import argonaut._, Argonaut._, ArgonautShapeless._
import org.http4s._, eveapi._, eveapi.data.crest._
"""
  , publish := {}
)
