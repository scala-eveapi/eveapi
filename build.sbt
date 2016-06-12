organization := "eveapi"
name := "eveapi"
scalaVersion in ThisBuild := "2.11.8"
version in ThisBuild := Version
scalafmtConfig in ThisBuild := Some((baseDirectory in root).value / ".scalafmt")

val globalSettings = reformatOnCompileSettings ++ addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.7.1")

lazy val Version = "0.1"

lazy val root = file(".")
lazy val data = (project in file("data")).settings(globalSettings)
lazy val compressed = (project in file("compressed")).settings(globalSettings)
lazy val compress = (project in file("compress")).settings(globalSettings).settings(
  version := Version,
  scalaVersion := "2.11.8",
  resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    , Resolver.sonatypeRepo("snapshots")
  ),
  libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.2.2"
    , "org.http4s" %% "http4s-blaze-client" % "0.14.0a-SNAPSHOT"
    , "com.chuusai" %% "shapeless" % "2.3.1"
  )
)
lazy val xml = (project in file("xml")).settings(globalSettings).settings(
  libraryDependencies ++= Seq(
      "org.scala-lang.modules"       %% "scala-xml"                % "1.0.3"
    , "org.scala-lang.modules"       %% "scala-parser-combinators" % "1.0.3"
  )
)

lazy val blazeClient = (project in file("blaze-client")).settings(globalSettings).settings(
  name := "blaze-client",
  libraryDependencies ++= Seq(
  )
).dependsOn(data, compressed)
