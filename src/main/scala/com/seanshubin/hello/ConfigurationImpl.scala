package com.seanshubin.hello

import java.nio.charset.Charset
import java.nio.file.Paths

class ConfigurationImpl(commandLineArguments: Seq[String],
                        files: FilesContract,
                        charset: Charset) extends Configuration {
  override def target: String = {
    val configFilePath = Paths.get(commandLineArguments.head)
    val bytes = files.readAllBytes(configFilePath)
    val text = new String(bytes.toArray, charset)
    text
  }
}
