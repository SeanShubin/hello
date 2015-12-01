package com.seanshubin.hello

import scala.collection.mutable.ArrayBuffer

class EmitStub extends ((String) => Unit) {
  val emitted: ArrayBuffer[String] = new ArrayBuffer

  override def apply(line: String): Unit = emitted.append(line)
}
