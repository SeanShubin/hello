package com.seanshubin.hello

import java.time.Duration

import org.scalatest.FunSuite

class TimerTest extends FunSuite {
  test("timer") {
    //given
    val clockStub = new ClockStub(Seq(1000, 1234))
    val timer = new TimerImpl(clockStub)
    val doNothingBlock: () => Unit = () => {}

    //when
    val duration = timer.measureTime {
      doNothingBlock()
    }

    //then
    assert(duration === Duration.ofMillis(234))
  }
}
