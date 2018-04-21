libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25" // Needed by sbt-git

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0")

addSbtPlugin("com.dwijnand" % "sbt-dynver" % "3.0.0")

addSbtPlugin("com.dwijnand" % "sbt-travisci" % "1.1.1")

addSbtPlugin("com.geirsson"  % "sbt-scalafmt" % "1.4.0")

addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.0.0")

addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.2.1")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.0")

addSbtPlugin("com.scalapenos" % "sbt-prompt" % "1.0.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")

addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.7")

addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.5.0")

addSbtPlugin("com.tapad" % "sbt-docker-compose" % "1.0.34")