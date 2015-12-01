package com.seanshubin.hello

class RunnerImpl(configuration: Configuration,
                 greeter: Greeter,
                 timer: Timer,
                 notifications: Notifications) extends Runnable {
  override def run(): Unit = {
    val timeTaken = timer.measureTime {
      val target = configuration.target
      greeter.greet(target)
    }
    notifications.timeTaken(timeTaken)
  }
}
