package com.seanshubin.hello

object ConsoleApplication extends App {
  new Wiring {
    override def commandLineArguments: Seq[String] = args
  }.runner.run()
}
