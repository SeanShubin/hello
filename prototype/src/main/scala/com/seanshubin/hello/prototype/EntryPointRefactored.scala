package com.seanshubin.hello.prototype

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}
import java.time.{Clock, Duration}

object EntryPointRefactored extends App {
  new DependencyInjection {
    override def commandLineArguments: Array[String] = args
  }.behavior.run()

}

trait DependencyInjection {
  def commandLineArguments: Array[String]

  lazy val clock: Clock = Clock.systemUTC()
  lazy val files: FilesContract = FilesFromOperatingSystem
  lazy val emit: String => Unit = println
  lazy val behavior: Runnable = new ApplicationBehavior(commandLineArguments, clock, files, emit)
}

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}

object FilesFromOperatingSystem extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = Files.readAllBytes(path)
}

class ApplicationBehavior(args: Array[String], clock: Clock, files: FilesContract, emit: String => Unit) extends Runnable {
  override def run(): Unit = {
    val startTime = clock.instant()
    val pathAsString = args.head
    val path = Paths.get(pathAsString)
    val bytes = files.readAllBytes(path)
    val charset = StandardCharsets.UTF_8
    val target = new String(bytes, charset)
    emit(s"Hello, $target!")
    val endTime = clock.instant()
    val duration = Duration.between(startTime, endTime)
    val durationMillis = duration.toMillis
    emit(s"$durationMillis milliseconds")
  }
}

