package com.seanshubin.hello

import java.nio.file.Paths
import java.time.Duration

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

class ApplicationTest extends FunSuite {
  test("application deep test") {
    //given
    val wiring = new DeterministicWiring {
      override def commandLineArguments = Seq("my-configuration.txt")

      override def clockTimes: Seq[Long] = Seq(1000, 1789)

      override def fileContents: String = "world"
    }

    //when
    wiring.application.run()

    //then
    assert(wiring.emitStub.emitted === Seq("Hello, world!", "789 milliseconds"))
    assert(wiring.filesStub.pathsRead === Seq(Paths.get("my-configuration.txt")))
  }

  test("application shallow test") {
    //given
    val configuration = new Configuration {
      override def target: String = "world"
    }
    val greetCalledWith: ArrayBuffer[String] = new ArrayBuffer
    val greeter = new Greeter {
      override def greet(target: String): Unit = greetCalledWith.append(target)
    }
    val timer = new Timer {
      override def measureTime(block: => Unit): Duration = {
        block
        Duration.ofMillis(1234)
      }
    }

    val timeTakenCalledWith: ArrayBuffer[Duration] = new ArrayBuffer
    val notifications = new Notifications {
      override def timeTaken(duration: Duration): Unit = timeTakenCalledWith.append(duration)
    }
    val runner = new ApplicationImpl(configuration, greeter, timer, notifications)

    //when
    runner.run()

    //then
    assert(greetCalledWith === Seq("world"))
    assert(timeTakenCalledWith === Seq(Duration.ofMillis(1234)))
  }
}
