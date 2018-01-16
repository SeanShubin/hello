package com.seanshubin.hello.prototype

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import java.time.{Clock, Duration}

object EntryPoint extends App {
  val startTime = Clock.systemUTC().instant()
  val target = new String(Files.readAllBytes(Paths.get(args.head)), StandardCharsets.UTF_8)
  println(s"Hello, $target!")
  val duration = Duration.between(startTime, Clock.systemUTC().instant())
  println(s"${duration.toMillis} milliseconds")
}
