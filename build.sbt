import org.eclipse.jgit.merge.MergeStrategy
import sbt.Keys.libraryDependencies

name          := "Tank"
organization  := "de.htwg.se"
version       := "0.0.1"
scalaVersion  := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12"
libraryDependencies += "junit" % "junit" % "4.8" % "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.1.1"
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12"
libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.1.1"
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6"

mainClass in Compile := Some("de.htwg.se.Tank.Tank")

lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

coverageExcludedPackages := "<empty>;.*MapGUI;.*TUI;.*animationtest;.*ItemTemplate;.*Observable;"

// Add JavaFX dependencies
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m=>
  "org.openjfx" % s"javafx-$m" % "11" classifier osName
)

val commonDependencies = Seq(
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.scala-lang.modules" %% "scala-swing" % "2.1.1",
  "net.codingwell" %% "scala-guice" % "4.2.6",
  "com.google.inject" % "guice" % "4.1.0",
  "com.typesafe.play" %% "play-json" % "2.8.1",
  "org.scala-lang.modules" %% "scala-xml" % "1.2.0"
)


lazy val tankBase = (project in file(".")).settings(
  name := "Tank",
  libraryDependencies ++= commonDependencies,
  assemblyMergeStrategy in assembly := {
    case PathList("reference.conf") => MergeStrategy.concat
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  },
  assemblyJarName in assembly := "Tank.jar",
  mainClass in assembly := Some("de.htwg.se.Tank.Tank")
)

//*******************************************************f************************//
//Libraries that we will use in later lectures compatible with this scala version
// uncomment to use!!

//libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.12" % "2.0.1"

//libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

//libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"

//libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"

//libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6"
