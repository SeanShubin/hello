package com.seanshubin.hello

import java.time.Duration

trait Timer {
  def measureTime(block: => Unit): Duration
}
