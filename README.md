# Hello Sample
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
- [prototype application without test coverage](src/test/scala/com/seanshubin/hello/PrototypeApp)

## Test Driven
- [unchanging, untested, entry point](src/main/scala/com/seanshubin/hello/ConsoleApplication)
- [changeable, testable, implementation](src/main/scala/com/seanshubin/hello/ApplicationImpl)

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
