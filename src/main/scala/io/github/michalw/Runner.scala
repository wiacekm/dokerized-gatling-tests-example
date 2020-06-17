package io.github.michalw

import java.net.URI
import java.nio.file.{FileSystems, Paths}
import java.util
import com.typesafe.scalalogging.StrictLogging
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder


object Runner extends App with StrictLogging {

  private def getConfigPath(uri: URI): String = {
    logger.debug(s"uri scheme:${uri.getScheme}")
    if (uri.getScheme.contains("jar")) {
      logger.debug(s"uri:$uri")
      val env: util.HashMap[String, String] = new util.HashMap()
      env.put("create", "true")
      val _ = FileSystems.newFileSystem(uri, env)
      val path = Paths.get(uri)
      path.toString
    } else
      Paths.get(uri).getParent.toString
  }

  private val results = System.getProperty("RESULTS", "/opt/log/results/") // FIXME: remove hardcoded path
  private val resource = getClass.getClassLoader.getResource("gatling.conf")
  logger.debug(s"resource:$resource")
  private val path = getConfigPath(resource.toURI)
  logger.debug(s"path:$path")
  private val props = new GatlingPropertiesBuilder()
    .resourcesDirectory(path)
    .binariesDirectory(path)
    .simulationClass("io.github.michalw.ExampleTest")
    .resultsDirectory(results)

  Gatling.fromMap(props.build)

}
