package com.seanshubin.hello

import java.time.{Clock, Instant, ZoneId}

class RuntimeControllableClockStub(initialTime: Long) extends Clock {
  var currentValue = initialTime

  override def getZone: ZoneId = ???

  override def instant(): Instant = {
    val result = Instant.ofEpochMilli(currentValue)
    result
  }

  def passTime(milliseconds: Long): Unit = {
    currentValue += milliseconds
  }

  override def withZone(zone: ZoneId): Clock = ???
}
