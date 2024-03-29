import sbt._
import Keys._

object TemplateBuild extends Build {

  lazy val projectSettings = Defaults.defaultSettings ++ Seq(
    name := "",
    version := "",
    organization := "",
    scalaVersion := "2.10.0-RC2",
    libraryDependencies += Dependency.libAkkaActor,
    libraryDependencies += Dependency.libAkkaCamel,
    libraryDependencies += Dependency.libAkkaRemote,
    libraryDependencies += Dependency.libAkkaTestkit,
    resolvers += Resolvers.sonatypeSnapshotRepo,
    resolvers += Resolvers.typesafeReleaseRepo,
    resolvers += Resolvers.typesafeSnapshotRepo
  )

  lazy val root = Project(id = "root", base = file("."), settings = projectSettings)
}


object Resolvers {
  val typesafeReleaseRepo = "Typesafe Snapshot Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
  val typesafeSnapshotRepo = "Typesafe Release Repository" at "http://repo.typesafe.com/typesafe/releases/"
  val sonatypeSnapshotRepo = "Scala Tools Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
}


object Dependency {
  val libAkkaActor = "com.typesafe.akka" %% "akka-actor" % "2.1.0-RC2" cross CrossVersion.full withSources() withJavadoc()
  val libAkkaRemote = "com.typesafe.akka" %% "akka-remote" % "2.1.0-RC2" cross CrossVersion.full withSources() withJavadoc()
  val libAkkaTestkit = "com.typesafe.akka" %% "akka-testkit" % "2.1.0-RC2" cross CrossVersion.full withSources() withJavadoc()
  val libAkkaCamel = "com.typesafe.akka" %% "akka-camel" % "2.1.0-RC2" cross CrossVersion.full withSources() withJavadoc()
}