package com.seanshubin.hello

import java.nio.charset.StandardCharsets

import org.scalatest.FunSuite

class ConfigurationTest extends FunSuite {
  test("load configuration") {
    //given
    val commandLineArguments = Seq("configuration-file.txt")
    val charset = StandardCharsets.UTF_8
    val sampleContent = "the target"
    val fakeFiles = new FilesStub(sampleContent, charset)
    val configuration: Configuration = new ConfigurationImpl(commandLineArguments, fakeFiles, charset)

    //when
    val actual = configuration.target

    //then
    assert(actual === "the target")
  }

}
