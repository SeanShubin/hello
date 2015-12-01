package com.seanshubin.hello

import java.time.Duration

class LineEmittingNotifications(emit: String => Unit) extends Notifications {
  override def timeTaken(duration: Duration): Unit = {
    emit(s"${duration.toMillis} milliseconds")
  }
}
