package com.seanshubin.hello

import java.nio.charset.StandardCharsets

import org.scalatest.FunSuite

class ApplicationBehaviorTest extends FunSuite {
  test("application behavior test") {
    //given
    val args = Seq("configuration.txt")
    val clock = new ClockStub(1000, 1789)
    val files = new FilesStub(Map("configuration.txt" -> "world"), StandardCharsets.UTF_8)
    val emit = new EmitStub
    val applicationBehavior = new ApplicationBehavior(args, clock, files, emit)

    //when
    applicationBehavior.run()

    //then
    assert(emit.emitted === Seq("Hello, world!", "789 milliseconds"))
  }
}
