name := "meetup"

logLevel := Level.Error

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

organization := "com.avenida"

version := "0.1"

scalaVersion := "2.11.6"

test in assembly := {}

val commonResolvers = Seq(Resolver.mavenLocal,
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Job Server Bintray" at "http://dl.bintray.com/spark-jobserver/maven",
  "Twitter" at "http://maven.twttr.com/")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "spark.jobserver" %% "job-server-api" % "0.5.1" % "provided",
  "org.apache.spark" %% "spark-core" % "1.4.0" % "provided",
  "org.apache.spark" %% "spark-mllib" % "1.4.0" % "provided"
)

resolvers ++= commonResolvers
