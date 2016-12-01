package com.seanshubin.hello

import java.time.Clock

trait DependencyInjection {
  def args: Seq[String]

  lazy val clock: Clock = Clock.systemUTC()
  lazy val files: FilesContract = FilesFromOperatingSystem
  lazy val emit: String => Unit = println
  lazy val behavior: Runnable = new ApplicationBehavior(args, clock, files, emit)
}
