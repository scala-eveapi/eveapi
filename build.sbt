organization := "eveapi"

name := "eveapi"

version := "1.0"

scalaVersion := "2.11.8"


lazy val data = project in file("data")
lazy val dataCompressed = project in file("data-compressed")
lazy val blazeClient = (project in file("blaze-client")).dependsOn(data, dataCompressed)