name := """spamfighter"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.apache.opennlp" % "opennlp-tools" % "1.5.3",
  "org.springframework" % "spring-context" % "4.1.2.RELEASE",
  "org.springframework" % "spring-core" % "4.1.2.RELEASE"
)
