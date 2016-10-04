package com.seanshubin.hello.prototype

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import java.time.{Clock, Duration}

object PrototypeApp extends App {
  val startTime = Clock.systemUTC().instant()
  val target = new String(Files.readAllBytes(Paths.get(args.head)), StandardCharsets.UTF_8)
  println(s"Hello, $target!")
  val duration = Duration.between(startTime, Clock.systemUTC().instant())
  println(s"${duration.toMillis} milliseconds")
}

/* final result

object PrototypeApp extends App {
  new Wiring {
    override def args: Seq[String] = PrototypeApp.args
  }.runner.run()
}

trait Wiring {
  def args: Seq[String]

  val clock: Clock = Clock.systemUTC()
  val files: FilesContract = FilesDelegate
  val emit: String => Unit = println
  val runner: Runnable = new Runner(args, clock, files, emit)
}

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}

object FilesDelegate extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = Files.readAllBytes(path)
}

class Runner(args: Seq[String], clock: Clock, files: FilesContract, emit: String => Unit) extends Runnable {
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

*/

/* create a contract to emit a line

object PrototypeApp extends App {
  new Wiring {
    override def args: Seq[String] = PrototypeApp.args
  }.runner.run()
}

trait Wiring {
  def args: Seq[String]

  val clock: Clock = Clock.systemUTC()
  val files: FilesContract = FilesDelegate
  val runner: Runnable = new Runner(args, clock, files)
}

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}

object FilesDelegate extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = Files.readAllBytes(path)
}

class Runner(args: Seq[String], clock: Clock, files: FilesContract) extends Runnable {
  override def run(): Unit = {
    val startTime = clock.instant()
    val pathAsString = args.head
    val path = Paths.get(pathAsString)
    val bytes = files.readAllBytes(path)
    val charset = StandardCharsets.UTF_8
    val target = new String(bytes, charset)
    println(s"Hello, $target!")
    val endTime = clock.instant()
    val duration = Duration.between(startTime, endTime)
    val durationMillis = duration.toMillis
    println(s"$durationMillis milliseconds")
  }
}

*/

/* put files behind contract

object PrototypeApp extends App {
  new Wiring{
    override def args: Seq[String] = PrototypeApp.args
  }.runner.run()
}

trait Wiring {
  def args: Seq[String]
  val clock:Clock = Clock.systemUTC()
  val runner: Runnable = new Runner(args, clock)
}

class Runner(args: Seq[String], clock:Clock) extends Runnable {
  override def run(): Unit = {
    val startTime = clock.instant()
    val pathAsString = args.head
    val path = Paths.get(pathAsString)
    val bytes = Files.readAllBytes(path)
    val charset = StandardCharsets.UTF_8
    val target = new String(bytes, charset)
    println(s"Hello, $target!")
    val endTime = clock.instant()
    val duration = Duration.between(startTime, endTime)
    val durationMillis = duration.toMillis
    println(s"$durationMillis milliseconds")
  }
}

*/

/* pull clock into wiring

object PrototypeApp extends App {
  new Wiring{
    override def args: Seq[String] = PrototypeApp.args
  }.runner.run()
}

trait Wiring {
  def args: Seq[String]

  val runner: Runnable = new Runner(args)
}

class Runner(args: Seq[String]) extends Runnable {
  override def run(): Unit = {
    val clock = Clock.systemUTC()
    val startTime = clock.instant()
    val pathAsString = args.head
    val path = Paths.get(pathAsString)
    val bytes = Files.readAllBytes(path)
    val charset = StandardCharsets.UTF_8
    val target = new String(bytes, charset)
    println(s"Hello, $target!")
    val endTime = clock.instant()
    val duration = Duration.between(startTime, endTime)
    val durationMillis = duration.toMillis
    println(s"$durationMillis milliseconds")
  }
}

*/

/* create wiring

object PrototypeApp extends App {
  new Runner(args).run()
}

class Runner(args: Seq[String]) extends Runnable {
  override def run(): Unit = {
    val clock = Clock.systemUTC()
    val startTime = clock.instant()
    val pathAsString = args.head
    val path = Paths.get(pathAsString)
    val bytes = Files.readAllBytes(path)
    val charset = StandardCharsets.UTF_8
    val target = new String(bytes, charset)
    println(s"Hello, $target!")
    val endTime = clock.instant()
    val duration = Duration.between(startTime, endTime)
    val durationMillis = duration.toMillis
    println(s"$durationMillis milliseconds")
  }
}

*/

/* split the entry point from the code

object PrototypeApp extends App {
  val clock = Clock.systemUTC()
  val startTime = clock.instant()
  val pathAsString = args.head
  val path = Paths.get(pathAsString)
  val bytes = Files.readAllBytes(path)
  val charset = StandardCharsets.UTF_8
  val target = new String(bytes, charset)
  println(s"Hello, $target!")
  val endTime = clock.instant()
  val duration = Duration.between(startTime, endTime)
  val durationMillis = duration.toMillis
  println(s"$durationMillis milliseconds")
}

*/

/* extract variables

object PrototypeApp extends App {
  val startTime = Clock.systemUTC().instant()
  val target = new String(Files.readAllBytes(Paths.get(args.head)), StandardCharsets.UTF_8)
  println(s"Hello, $target!")
  val duration = Duration.between(startTime, Clock.systemUTC().instant())
  println(s"${duration.toMillis} milliseconds")
}

*/
