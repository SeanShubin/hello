package com.seanshubin.hello

import java.time.Clock

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
