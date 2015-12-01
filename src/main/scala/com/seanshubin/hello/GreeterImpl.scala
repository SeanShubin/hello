package com.seanshubin.hello

class GreeterImpl(emit: String => Unit) extends Greeter {
  override def greet(target: String): Unit = {
    emit(s"Hello, $target!")
  }
}
