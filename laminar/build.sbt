enablePlugins(ScalaJSPlugin)
name := "Text Counter Application using Laminar"
scalaVersion := "2.13.12"
scalaJSUseMainModuleInitializer := true
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0"
libraryDependencies += "com.raquo" %%% "laminar" % "16.0.0"
