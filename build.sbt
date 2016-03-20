name := "template-api-rest-java-playframework"

version := "1.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.dbunit" % "dbunit" % "2.4.9",
  cache,
  javaWs,
  evolutions,
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.8.5",
  "org.webjars" % "angularjs" % "1.5.0" exclude("org.webjars", "jquery"),
  "org.jboss.resteasy"          %   "resteasy-jaxrs"          % "3.0.9.Final",
  "org.jboss.resteasy"          %   "resteasy-client"         % "3.0.9.Final",
  "org.jboss.resteasy" % "resteasy-jackson-provider" % "3.0.16.Final",
  "org.seleniumhq.selenium" % "selenium-java" % "2.53.0",
  "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.42.2",
  "junit" % "junit" % "4.11" % Test

)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
