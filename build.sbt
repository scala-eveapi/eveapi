organization := "eveapi"
name := "eveapi"
version := "0.1"
scalaVersion := "2.11.8"

lazy val data = (project in file("data")).settings(
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-client" % "0.14.0a-SNAPSHOT"
  ),
  resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    , Resolver.sonatypeRepo("snapshots")
  )

)
lazy val compressed = (project in file("compressed")).settings(
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.2.2"
    , "com.chuusai" %% "shapeless" % "2.3.1"
  )
)
lazy val xml = (project in file("xml")).settings(
  scalaVersion := "2.11.8"
)

lazy val blazeClient = (project in file("blaze-client"))
  .settings(
    scalaVersion := "2.11.8",
    name := "blaze-client",
    libraryDependencies ++= Seq(
    )
  )
  .dependsOn(data, compressed)
