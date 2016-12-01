package com.seanshubin.hello

import java.nio.charset.Charset
import java.nio.file.Path

class FilesStub(content: Map[String, String], charset: Charset) extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = {
    content(path.toString).getBytes(charset)
  }
}
