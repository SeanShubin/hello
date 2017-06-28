package com.seanshubin.hello

import java.nio.charset.StandardCharsets
import java.nio.file.Path

class FilesStub(content: Map[String, String]) extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = {
    content(path.toString).getBytes(StandardCharsets.UTF_8)
  }
}
