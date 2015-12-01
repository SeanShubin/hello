package com.seanshubin.hello

import java.nio.file.Paths
import java.time.Clock

import org.scalatest.FunSuite

class RunnerTest extends FunSuite {
  test("application flow") {
    //given
    val wiring = new DeterministicWiring {
      override def theCommandLineArguments = Seq("my-configuration.txt")

      override def clockTimes: Seq[Long] = Seq(1000, 1789)

      override def fileContents: String = "world"
    }

    //when
    wiring.runner.run()

    //then
    assert(wiring.emitStub.emitted.size === 2)
    assert(wiring.emitStub.emitted(0) === "Hello, world!")
    assert(wiring.emitStub.emitted(1) === "789 milliseconds")
    assert(wiring.filesStub.pathsRead.size === 1)
    assert(wiring.filesStub.pathsRead(0) === Paths.get("my-configuration.txt"))
  }

  abstract class DeterministicWiring extends Wiring {
    def theCommandLineArguments: Seq[String]

    def clockTimes: Seq[Long]

    def fileContents: String

    val filesStub = new FilesStub(fileContents, charset)
    val emitStub = new EmitStub

    override def commandLineArguments: Seq[String] = theCommandLineArguments

    override lazy val emitLine: (String) => Unit = emitStub

    override lazy val files: FilesContract = filesStub

    override lazy val clock: Clock = new ClockStub(clockTimes)
  }

}
