package com.seanshubin.hello

import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{Files, Paths}
import java.time.{Clock, Duration}

object PrototypeApp extends App {
  val clock: Clock = Clock.systemUTC()
  val charset: Charset = StandardCharsets.UTF_8

  val before = clock.instant()

  val configFilePath = Paths.get(args.head)
  val bytes = Files.readAllBytes(configFilePath)
  val target = new String(bytes, charset)
  println(s"Hello, $target!")

  val after = clock.instant()
  val duration = Duration.between(before, after)
  println(s"${duration.toMillis} milliseconds")
}
