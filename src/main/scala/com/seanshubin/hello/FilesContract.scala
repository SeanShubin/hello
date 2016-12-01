package com.seanshubin.hello

import java.nio.file.Path

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}
