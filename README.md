# Hello Sample
- Sample project demonstrating how to test drive your non deterministic code
- Non-determinism highlighted:
    - console output
    - file system
    - system clock

# Most tests should be both deterministic and fast 
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
