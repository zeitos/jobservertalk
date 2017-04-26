name := "meetup"

logLevel := Level.Error

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

organization := "com.jampp"

version := "0.1"

scalaVersion := "2.11.6"

test in assembly := {}

val commonResolvers = Seq(Resolver.mavenLocal,
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Job Server Bintray" at "http://dl.bintray.com/spark-jobserver/maven",
  "Twitter" at "http://maven.twttr.com/")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "spark.jobserver" %% "job-server-api" % "0.7.0" % "provided",
  "org.apache.spark" %% "spark-core" % "1.6.2" % "provided",
  "org.apache.spark" %% "spark-mllib" % "1.6.2" % "provided"
)

resolvers ++= commonResolvers
