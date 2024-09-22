# Karate Spring Boot Project

Karate example project - 1.5.0 

## Run Project

````Maven
mvn clean install
````

````Bash
mvn clean spring-boot:run
````

```Bash
mvn clean test -Denv=local -DclientId=test -DclientSecret=test
````

## Installation

Windows:
```bash
mvn archetype:generate `
-DarchetypeGroupId=com.intuit.karate `
-DarchetypeArtifactId=karate-archetype `
-DarchetypeVersion=X.X.X `
-DgroupId=com.nallani `
-DartifactId=karate-project
```
Mac:
```bash
mvn archetype:generate \
-DarchetypeGroupId=io.karatelabs \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.5.0 \
-DgroupId=com.nallani \
-DartifactId=karate-project
```
### Required
**Note: Enforced by maven enforcer plugin**

* Java 21
* Maven 3


## Spotless Usage
**NOTE: Project is formatted using spotless and git pre commit**

````Shell
mvn spotless:check
mvn spotless:apply
````

### Terminate Port:

````shell
netstat -ano | findstr :8080
````
````shell
taskkill //PID 22280 //F
````