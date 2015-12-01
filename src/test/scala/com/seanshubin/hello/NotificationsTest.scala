package com.seanshubin.hello

import java.time.Duration

import org.scalatest.FunSuite

class NotificationsTest extends FunSuite {
  test("notify time taken") {
    //given
    val emitStub = new EmitStub
    val notifications = new LineEmittingNotifications(emitStub)
    val duration: Duration = Duration.ofMillis(42)

    //when
    notifications.timeTaken(duration)

    //then
    assert(emitStub.emitted.size === 1)
    assert(emitStub.emitted.head === "42 milliseconds")
  }
}
