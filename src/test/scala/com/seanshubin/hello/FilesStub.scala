package com.seanshubin.hello

import java.nio.charset.Charset
import java.nio.file.Path

import scala.collection.mutable.ArrayBuffer

class FilesStub(sampleContent: String, charset: Charset) extends FilesNotImplemented {
  val pathsRead: ArrayBuffer[Path] = new ArrayBuffer

  override def readAllBytes(path: Path): Seq[Byte] = {
    pathsRead.append(path)
    sampleContent.getBytes(charset)
  }
}
