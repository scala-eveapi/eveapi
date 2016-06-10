organization := "eveapi"
name := "eveapi"
version := "0.1"
scalaVersion := "2.11.8"

lazy val data = project in file("data")
lazy val compressed = project in file("compressed")
lazy val xml = project in file("xml")

lazy val blazeClient = (project in file("blaze-client"))
  .settings(
    name := "blaze-client",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-client" % "0.13.2"
    )
  )
  .dependsOn(data, compressed)
