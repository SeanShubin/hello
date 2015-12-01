package com.seanshubin.hello

import org.scalatest.FunSuite

class GreeterTest extends FunSuite {
  test("compose greeting") {
    //given
    val emitStub = new EmitStub
    val greeter = new GreeterImpl(emitStub)

    //when
    greeter.greet("test")

    //then
    assert(emitStub.emitted.size === 1)
    assert(emitStub.emitted(0) === "Hello, test!")
  }
}
