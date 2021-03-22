# P2 Address

## 3) Integration test 

```bash
$ mvn test 

$ mvn install
```
will only run test classes that end with "TEST"

```bash
$ mvn installfailsafe:integration-test 
```

will run test classes that end with "TEST" as well as test classes that end with "IT" which means it is an integration test

