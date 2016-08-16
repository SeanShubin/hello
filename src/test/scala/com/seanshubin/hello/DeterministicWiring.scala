package com.seanshubin.hello

import java.time.Clock

abstract class DeterministicWiring extends Wiring {
  def clockTimes: Seq[Long]

  def fileContents: String

  val filesStub = new FilesStub(fileContents, charset)
  val emitStub = new EmitStub

  override lazy val emitLine: (String) => Unit = emitStub

  override lazy val files: FilesContract = filesStub

  override lazy val clock: Clock = new PredeterminedClockStub(clockTimes)
}
