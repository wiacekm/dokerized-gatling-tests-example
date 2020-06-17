
logLevel := Level.Warn
addSbtPlugin("io.gatling" % "gatling-sbt" % "3.1.0")
// for releasing
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.4")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.0")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.9")
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.2")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt-coursier" % "1.12")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.0")