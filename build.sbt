name := "scala-test-libs"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq (
	"org.scalatest" %% "scalatest" % "2.0.M5b" % "test",
	"org.specs2" %% "specs2" % "1.13" % "test",
	"org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
	
)

resolvers += "OSS Sonatype"  at "http://oss.sonatype.org/content/repositories/releases"
