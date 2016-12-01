package com.seanshubin.hello

import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import java.time.{Clock, Duration}

class ApplicationBehavior(args: Seq[String], clock: Clock, files: FilesContract, emit: String => Unit) extends Runnable {
  override def run(): Unit = {
    //    val startTime = Clock.systemUTC().instant()
    //    val target = new String(Files.readAllBytes(Paths.get(args.head)), StandardCharsets.UTF_8)
    //    println(s"Hello, $target!")
    //    val duration = Duration.between(startTime, Clock.systemUTC().instant())
    //    println(s"${duration.toMillis} milliseconds")
    //
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
