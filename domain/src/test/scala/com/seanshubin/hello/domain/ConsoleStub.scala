package com.seanshubin.hello.domain

import scala.collection.mutable.ArrayBuffer

class ConsoleStub extends (String => Unit) {
  val linesEmitted: ArrayBuffer[String] = new ArrayBuffer

  override def apply(line: String): Unit = linesEmitted.append(line)
}
