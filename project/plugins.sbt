logLevel := Level.Warn

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.12.0")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.6.0")

addSbtPlugin("com.twitter" %% "scrooge-sbt-plugin" % "3.14.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.98.0")

resolvers += "bigtoast-github" at "http://bigtoast.github.com/repo/"

addSbtPlugin("com.github.bigtoast" % "sbt-thrift" % "0.7")

//addSbtPlugin("emchristiansen" % "sbt-latex" % "0.1.2")

addSbtPlugin("org.rbayer" % "grunt-sbt" % "1.0")

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"
