package com.seanshubin.hello.domain

import java.nio.file.{Files, Path}

object FilesFromOperatingSystem extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = Files.readAllBytes(path)
}
