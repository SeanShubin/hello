package com.seanshubin.hello.domain

import org.scalatest.FunSuite

class ApplicationBehaviorTest extends FunSuite {
  test("application behavior test") {
    //given
    val args = Seq("configuration.txt")
    val clock = new ClockStub(1000, 1789)
    val files = new FilesStub(Map("configuration.txt" -> "world"))
    val console = new ConsoleStub
    val applicationBehavior = new ApplicationBehavior(args, clock, files, console)

    //when
    applicationBehavior.run()

    //then
    assert(console.linesEmitted === Seq("Hello, world!", "789 milliseconds"))
  }
}
