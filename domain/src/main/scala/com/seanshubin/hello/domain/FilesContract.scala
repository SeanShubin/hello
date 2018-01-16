package com.seanshubin.hello.domain

import java.nio.file.Path

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}
