package com.seanshubin.hello

import java.time.Duration

import org.scalatest.FunSuite

class TimerTest extends FunSuite {
  test("timer") {
    //given
    val clockStub = new RuntimeControllableClockStub(1000)
    val timer = new TimerImpl(clockStub)
    var blockInvocationCount = 0
    val doNothingBlock: () => Unit = () => {
      clockStub.passTime(234)
      blockInvocationCount += 1
    }

    //when
    val duration = timer.measureTime {
      doNothingBlock()
    }

    //then
    assert(duration === Duration.ofMillis(234))
    assert(blockInvocationCount == 1)
  }
}
