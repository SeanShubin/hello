package com.seanshubin.hello.prototype

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}
import java.time.{Clock, Duration}

object EntryPoint extends App {
  val startTime = Clock.systemUTC().instant()
  val target = new String(Files.readAllBytes(Paths.get(args.head)), StandardCharsets.UTF_8)
  println(s"Hello, $target!")
  val duration = Duration.between(startTime, Clock.systemUTC().instant())
  println(s"${duration.toMillis} milliseconds")
}

/*
// final result

object EntryPoint extends App {
  new DependencyInjection {
    override def args: Seq[String] = EntryPoint.args
  }.behavior.run()
}

trait DependencyInjection {
  def args: Seq[String]

  val clock: Clock = Clock.systemUTC()
  val files: FilesContract = FilesFromOperatingSystem
  val emit: String => Unit = println
  val behavior: Runnable = new ApplicationBehavior(args, clock, files, emit)
}

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}

object FilesFromOperatingSystem extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = Files.readAllBytes(path)
}

class ApplicationBehavior(args: Seq[String], clock: Clock, files: FilesContract, emit: String => Unit) extends Runnable {
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

/*
// create a contract to emit a line

object EntryPoint extends App {
  new DependencyInjection {
    override def args: Seq[String] = EntryPoint.args
  }.behavior.run()
}

trait DependencyInjection {
  def args: Seq[String]

  val clock: Clock = Clock.systemUTC()
  val files: FilesContract = FilesFromOperatingSystem
  val behavior: Runnable = new ApplicationBehavior(args, clock, files)
}

trait FilesContract {
  def readAllBytes(path: Path): Array[Byte]
}

object FilesFromOperatingSystem extends FilesContract {
  override def readAllBytes(path: Path): Array[Byte] = Files.readAllBytes(path)
}

class ApplicationBehavior(args: Seq[String], clock: Clock, files: FilesContract) extends Runnable {
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

/*
// put files behind contract

object EntryPoint extends App {
  new DependencyInjection{
    override def args: Seq[String] = EntryPoint.args
  }.behavior.run()
}

trait DependencyInjection {
  def args: Seq[String]
  val clock:Clock = Clock.systemUTC()
  val behavior: Runnable = new ApplicationBehavior(args, clock)
}

class ApplicationBehavior(args: Seq[String], clock:Clock) extends Runnable {
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

/*
// pull clock into DependencyInjection

object EntryPoint extends App {
  new DependencyInjection{
    override def args: Seq[String] = EntryPoint.args
  }.behavior.run()
}

trait DependencyInjection {
  def args: Seq[String]

  val behavior: Runnable = new ApplicationBehavior(args)
}

class ApplicationBehavior(args: Seq[String]) extends Runnable {
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

/*
// dependency injection

object EntryPoint extends App {
  new ApplicationBehavior(args).run()
}

class ApplicationBehavior(args: Seq[String]) extends Runnable {
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

/*
// split the entry point from the code

object EntryPoint extends App {
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

/*
// extract variables

object EntryPoint extends App {
  val startTime = Clock.systemUTC().instant()
  val target = new String(Files.readAllBytes(Paths.get(args.head)), StandardCharsets.UTF_8)
  println(s"Hello, $target!")
  val duration = Duration.between(startTime, Clock.systemUTC().instant())
  println(s"${duration.toMillis} milliseconds")
}

*/
