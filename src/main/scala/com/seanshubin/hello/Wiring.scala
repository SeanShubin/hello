package com.seanshubin.hello

import java.nio.charset.{Charset, StandardCharsets}
import java.time.Clock

trait Wiring {
  def commandLineArguments: Seq[String]

  lazy val emitLine: String => Unit = println
  lazy val files: FilesContract = FilesDelegate
  lazy val charset: Charset = StandardCharsets.UTF_8
  lazy val notifications: Notifications = new LineEmittingNotifications(emitLine)
  lazy val configuration: Configuration = new ConfigurationImpl(commandLineArguments, files, charset)
  lazy val clock: Clock = Clock.systemUTC()
  lazy val timer: Timer = new TimerImpl(clock)
  lazy val greeter: Greeter = new GreeterImpl(emitLine)
  lazy val runner: Runnable = new RunnerImpl(configuration, greeter, timer, notifications)
}
