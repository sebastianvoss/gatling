import sbt._

object Dependencies {

  // Compile dependencies

  // format: OFF
  private def scalaReflect(version: String)  = "org.scala-lang"             % "scala-reflect"                   % version
  private def scalaCompiler(version: String) = "org.scala-lang"             % "scala-compiler"                  % version
  private val scalaSwing                     = "org.scala-lang.modules"              %% "scala-swing"                     % "2.0.1"
  private val scalaXml                       = "org.scala-lang.modules"              %% "scala-xml"                       % "1.1.0"
  private val scalaParserCombinators         = "org.scala-lang.modules"              %% "scala-parser-combinators"        % "1.1.1"
  private val java8Compat                    = "org.scala-lang.modules"              %% "scala-java8-compat"              % "0.9.0"
  private val netty                          = "io.netty"                             % "netty-codec-http"                % "4.1.30.Final"
  private val nettyBuffer                    = netty.organization                     % "netty-buffer"                    % netty.revision
  private val nettyHandler                   = netty.organization                     % "netty-handler"                   % netty.revision
  private val nettyProxy                     = netty.organization                     % "netty-handler-proxy"             % netty.revision
  private val nettyDns                       = netty.organization                     % "netty-resolver-dns"              % netty.revision
  private val nettyNativeTransport           = netty.organization                     % "netty-transport-native-epoll"    % netty.revision classifier "linux-x86_64"
  private val nettyHttp2                     = netty.organization                     % "netty-codec-http2"               % netty.revision
  private val nettyBoringSsl                 = netty.organization                     % "netty-tcnative-boringssl-static" % "2.0.15.Final"
  private val activation                     = "com.sun.activation"                   % "javax.activation"                % "1.2.0"
  private val akka                           = "com.typesafe.akka"                   %% "akka-actor"                      % "2.5.17"
  private val akkaSlf4j                      = akka.organization                     %% "akka-slf4j"                      % akka.revision
  private val config                         = "com.typesafe"                         % "config"                          % "1.3.3"
  private val saxon                          = "net.sf.saxon"                         % "Saxon-HE"                        % "9.9.0-1"
  private val slf4jApi                       = "org.slf4j"                            % "slf4j-api"                       % "1.7.25"
  private val fastring                       = "com.dongxiguo"                       %% "fastring"                        % "1.0.0"
  private val spire                          = ("org.typelevel"                      %% "spire-macros"                    % "0.16.0")
    .exclude("org.typelevel", "machinist_2.12")
    .exclude("org.typelevel", "algebra_2.12")
  private val scopt                          = "com.github.scopt"                    %% "scopt"                           % "3.7.0"
  private val scalaLogging                   = "com.typesafe.scala-logging"          %% "scala-logging"                   % "3.9.0"
  private val jackson                        = "com.fasterxml.jackson.core"           % "jackson-databind"                % "2.9.7"
  private val sfm                            = ("org.simpleflatmapper"                % "lightning-csv"                   % "6.0.1")
    .exclude("org.simpleflatmapper", "ow2-asm")
  private val sfmUtil                        = "org.simpleflatmapper"                 % "sfm-util"                        % sfm.revision
  private val json4sJackson                  = "org.json4s"                          %% "json4s-jackson"                  % "3.6.1"
  private val jsonpath                       = "io.gatling"                          %% "jsonpath"                        % "0.6.14"
  private val joddJson                       = "org.jodd"                             % "jodd-json"                       % "5.0.5"
  private val joddLagarto                    = joddJson.organization                  % "jodd-lagarto"                    % joddJson.revision
  private val boopickle                      = "io.suzaku"                           %% "boopickle"                       % "1.3.0"
  private val redisClient                    = "net.debasishg"                       %% "redisclient"                     % "3.7"
  private val zinc                           = ("org.scala-sbt"                      %% "zinc"                            % "1.2.4")
    .exclude("org.scala-lang.modules", "scala-parser-combinators_2.12")
    .exclude("org.scala-lang.modules", "scala-xml_2.12")
    .exclude("org.scala-sbt", "launcher-interface")
    .exclude("org.scala-sbt", "sbinary_2.12")
    .exclude("org.scala-sbt", "zinc-ivy-integration_2.12")
    .exclude("com.eed3si9n", "sjson-new-core_2.12")
    .exclude("com.eed3si9n", "sjson-new-scalajson_2.12")
    .exclude("com.lihaoyi", "fastparse_2.12")
    .exclude("com.lmax", "disruptor")
    .exclude("jline", "jline")
    .exclude("org.apache.logging.log4j", "log4j-api")
    .exclude("org.apache.logging.log4j", "log4j-core")
  private val compilerBridge                 = "org.scala-sbt"                       %% "compiler-bridge"                 % zinc.revision
  private val jmsApi                         = "org.apache.geronimo.specs"            % "geronimo-jms_1.1_spec"           % "1.1.1"
  private val logback                        = "ch.qos.logback"                       % "logback-classic"                 % "1.2.3"
  private val tdigest                        = "com.tdunning"                         % "t-digest"                        % "3.1"
  private val hdrHistogram                   = "org.hdrhistogram"                     % "HdrHistogram"                    % "2.1.10"
  private val caffeine                       = "com.github.ben-manes.caffeine"        % "caffeine"                        % "2.6.2"
  private val bouncycastle                   = "org.bouncycastle"                     % "bcpkix-jdk15on"                  % "1.60"
  private val quicklens                      = "com.softwaremill.quicklens"          %% "quicklens"                       % "1.4.11"
  private val fastUuid                       = "com.eatthepath"                       % "fast-uuid"                       % "0.1"
  private val testInterface                  = "org.scala-sbt"                        % "test-interface"                  % "1.0"
  private val pebble                         = "io.pebbletemplates"                   % "pebble"                          % "3.0.5"

  // Test dependencies

  private val scalaTest                      = "org.scalatest"                       %% "scalatest"                       % "3.0.5"             % "test"
  private val scalaCheck                     = "org.scalacheck"                      %% "scalacheck"                      % "1.14.0"            % "test"
  private val akkaTestKit                    = akka.organization                     %% "akka-testkit"                    % akka.revision       % "test"
  private val mockitoCore                    = "org.mockito"                          % "mockito-core"                    % "2.22.0"            % "test"
  private val activemqBroker                 = "org.apache.activemq"                  % "activemq-broker"                 % "5.15.7"            % "test"
  private val h2                             = "com.h2database"                       % "h2"                              % "1.4.197"           % "test"
  private val jmh                            = "org.openjdk.jmh"                      % "jmh-core"                        % "1.21"

  private val junit                          = "org.junit.jupiter"                    % "junit-jupiter-api"               % "5.3.1"             % "test"
  private val jetty                          = "org.eclipse.jetty"                    % "jetty-server"                    % "9.4.12.v20180830"  % "test"
  private val jettyProxy                     = jetty.organization                     % "jetty-proxy"                     % jetty.revision      % "test"

  // format: ON

  private val loggingDeps = Seq(slf4jApi, scalaLogging)
  private val testDeps = Seq(scalaTest, scalaCheck, akkaTestKit, mockitoCore)
  private val parserDeps = Seq(jsonpath, jackson, joddJson, saxon, joddLagarto)

  // Dependencies by module

  val nettyUtilDependencies =
    Seq(nettyBuffer, junit)

  def commonsDependencies(scalaVersion: String) =
    Seq(scalaReflect(scalaVersion), config, fastring, boopickle, spire, quicklens, java8Compat, fastUuid) ++ loggingDeps ++ testDeps

  val coreDependencies =
    Seq(akka, akkaSlf4j, sfm, sfmUtil, java8Compat, caffeine, pebble, scalaParserCombinators, scopt) ++
      parserDeps ++ testDeps

  val redisDependencies = redisClient +: testDeps

  val httpClientDependencies = Seq(netty, nettyBuffer, nettyHandler, nettyProxy, nettyDns, nettyNativeTransport, nettyHttp2, nettyBoringSsl, activation, junit, jetty, jettyProxy) ++ loggingDeps

  val httpDependencies = Seq(scalaXml) ++ testDeps

  val jmsDependencies = Seq(jmsApi, activemqBroker) ++ testDeps

  val jdbcDependencies = h2 +: testDeps

  val chartsDependencies = tdigest +: testDeps

  val graphiteDependencies = hdrHistogram +: testDeps

  val benchmarkDependencies = Seq(jmh)

  def compilerDependencies(scalaVersion: String) =
    Seq(scalaCompiler(scalaVersion), scalaReflect(scalaVersion), config, slf4jApi, logback, zinc, compilerBridge, scopt)

  val recorderDependencies = Seq(scalaSwing, jackson, json4sJackson, bouncycastle, netty, akka) ++ testDeps

  val testFrameworkDependencies = Seq(testInterface)

  val docDependencies = Seq(activemqBroker)
}
