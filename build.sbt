organization := "html-extractor"

scalaVersion := "2.11.8"

lazy val http4sVersion = "0.14.11"

name := "html-extractor"

version := "0.1.1"

assemblyOutputPath in assembly := file("jars/html-extractor.jar")

libraryDependencies ++= Seq(
  "com.syncthemall" % "boilerpipe" % "1.2.1",
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.slf4j" % "slf4j-simple" % "1.7.22",
  "xerces" % "xercesImpl" % "2.8.0"
)

assemblyMergeStrategy in assembly := {
  case PathList("org", "cyberneko", "html", ps @ _*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
