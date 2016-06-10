organization := "eveapi"
name := "eveapi"
scalaVersion := "2.11.8"
version := Version

lazy val Version = "0.1"

lazy val data = (project in file("data")).settings(
  version := Version,
  scalaVersion := "2.11.8"
)
lazy val compressed = (project in file("compressed")).settings(
  version := Version,
  scalaVersion := "2.11.8"
)
lazy val compress = (project in file("compress")).settings(
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
lazy val xml = (project in file("xml")).settings(
  version := Version,
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "org.scala-lang.modules"       %% "scala-xml"                % "1.0.3",
    "org.scala-lang.modules"       %% "scala-parser-combinators" % "1.0.3"
  ),
  sourceGenerators in Compile += Def.task { "./xml/build.sh".lines_!.toList.map(file)}.taskValue
)

lazy val blazeClient = (project in file("blaze-client")) .settings(
    version := Version,
    scalaVersion := "2.11.8",
    name := "blaze-client",
    libraryDependencies ++= Seq(
    )
).dependsOn(data, compressed)
