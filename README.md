# Hello Sample
- [YouTube](https://www.youtube.com/watch?v=b8EB31voC9U)
- Sample project demonstrating how to test drive your non deterministic code
- Non-determinism highlighted:
    - console output
    - file system
    - system clock


## Steps to run
- mvn package
- java -jar target/hello.jar configuration.txt

## Specification
- input
    - command line argument
    - specifies the name of a file
- behavior
    - load the target from the file in utf-8
    - compose a greeting message that says hello to the target
    - display the greeting message to the console
    - display the time taken in milliseconds to the console

## Prototype
                                                
- [prototype application without test coverage](prototype/src/main/scala/com/seanshubin/hello/prototype/EntryPoint.scala)

## Test Driven
- [unchanging, untested, entry point with no logic](console/src/main/scala/com/seanshubin/hello/console/EntryPoint.scala)
- [changeable, testable, implementation](domain/src/main/scala/com/seanshubin/hello/domain/ApplicationBehavior.scala)

## Types of tests
- [functions](domain/src/test/scala/com/seanshubin/hello/domain/FilesStub.scala)
- [unpredictable](domain/src/test/scala/com/seanshubin/hello/domain/ClockStub.scala)
- [side effects](domain/src/test/scala/com/seanshubin/hello/domain/ConsoleStub.scala)

## Tests should be both deterministic and fast 
- deterministic
    - we only access what the code can directly control
    - we do not access
        - network
        - file system
        - system clock
        - environment variables
        - jvm properties
        - database
- fast
    - we are only testing one thing, and perform only just enough setup to do that one thing
    - we do not
        - read a configuration file
        - perform dynamic wiring
        - start a framework to invoke us
        - start a web container
        - create massive amounts of test data
