# Lab06

## Sonar Qube usage

```
cd /Documents/sonarqube-8.8.0.42792/bin/linux-x86-64
```
```
./sonar.sh { console | start | stop | force-stop | restart | status | dump }
```

http://localhost:9000/

username: admin / password: vbnvbn (inicialmente admin)

sonar token generated: 5211b0db2633e356a07c4875b1d38272489e9bc9

**run in project folder** (Reused P2 form lab02)

```
mvn sonar:sonar \
  -Dsonar.projectKey=P1SonarQube \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=5211b0db2633e356a07c4875b1d38272489e9bc9
```

## 1 f)

1 bug / 1 security hotspots / 33 code smells

### security hotspots

```
Random generator = new Random();
```

**Problem:**
Using pseudorandom number generators (PRNGs) is security-sensitive.

When software generates predictable values in a context requiring unpredictability, it may be possible for an attacker to guess the next value that will be generated, and use this guess to impersonate another user or access sensitive information.

**Fix:**

Use a cryptographically strong random number generator (RNG) like "java.security.SecureRandom" in place of this PRNG.
Use the generated random values only once.



### bug

```
Random generator = new Random();
```

**Problem:**
"Random" objects should be reused.

Creating a new Random object each time a random value is needed is inefficient and may produce numbers which are not random depending on the JDK. 

**Fix:**
For better efficiency and randomness, create a single Random, then store, and reuse it

### major code smell 1

```
public boolean intersects(SetOfNaturals subset) {
		return false;
	}
```
**Problem:**
Unused method parameters should be removed -> subset

**Fix:**
```
public boolean intersects() {
		return false;
	}
```

### major code smell 2 (multiple occasions)

```
for (int i = 0; i < maxnumbers; ) {
            int candidate = generator.nextInt(numberlimit) + 1;
            if (!randomDip.getNumbersColl().contains(candidate)) {
                randomDip.getNumbersColl().add(candidate);
                i++;
            }
        }
```

**Problem:**
Refactor the code in order to not assign to this loop counter from within the loop body

**Fix:**

```
for (int i = 0; i < maxnumbers; i++)
```

### major code smell 3 (multiple occasions)

**Problem:**

System.out.println is not the best approach

```
System.out.println("Betting with three random bets...");
```

**Fix:**
```
 Logger logger
                = Logger.getLogger(
                DemoMain.class.getName());
                
logger.log(Level.INFO,"Betting with three random bets...");
```
**Second Fix** (had code smell again):

```
logger.log(Level.INFO,"You played: {0} ", thisWeek.format());
```

### critical code smell 1 (multiple occasions)

**Problem:**

```
final static int maxnumbers = 5;
```

**Fix:**

```
final static int MAXNUMBERS = 5;
```
### 2 a) Explain what debt means (in this context)

**Debt** is basically the estimated time to resolve all the issues,

Before starting to resolve my project bugs/vulnerabilities/code smells, the estimated time was more than 2 hours. After resolving, it went down to 45 minutes.

If we click on it, we also get more information, for example, the estimated time on each of the files that still have issues.

In my case, my 45 minutes are divided into 5:

**SetOfNaturalsTest.java**: 14 minutes

**EuromillionsDraw.java**: 13 minutes

**Dip.java**: 8 minutes

**DipTest.java**: 6 minutes

**EuromillionsDrawTest.java**: 8 minutes

## Overall code after resolving previous issues

0 Bugs / 0 Vulnerabilities / 0 Hotspots

45 min debt

19 code smell (0 major / 0 critical)

71.7% coverage (on 128 lines to cover) (9 unit tests)

