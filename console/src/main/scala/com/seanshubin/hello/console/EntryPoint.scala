package com.seanshubin.hello.console

object EntryPoint extends App {
  new DependencyInjection {
    override def args: Seq[String] = EntryPoint.args
  }.behavior.run()
}
