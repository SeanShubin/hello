package com.seanshubin.hello

object EntryPoint extends App {
  new DependencyInjection {
    override def args: Seq[String] = EntryPoint.args
  }.behavior.run()
}
