# Kogito Event Driven Decisioning

## Description

A minimal example of how to use kogito for event driven decisioning (stateful session)

## Installing and Running

### Prerequisites

You will need:
  - Java 11+ installed
  - Environment variable JAVA_HOME set accordingly
  - Maven 3.6.2+ installed

When using native image compilation, you will also need:
  - [GraalVM 19.1.1](https://github.com/oracle/graal/releases/tag/vm-19.1.1) installed
  - Environment variable GRAALVM_HOME set accordingly
  - Note that GraalVM native image compilation typically requires other packages (glibc-devel, zlib-devel and gcc) to be installed too.  You also need 'native-image' installed in GraalVM (using 'gu install native-image'). Please refer to [GraalVM installation documentation](https://www.graalvm.org/docs/reference-manual/aot-compilation/#prerequisites) for more details.

### Run in Local Dev Mode

```sh
mvn clean quarkus:dev
```

### Package and Run in JVM mode

```sh
mvn clean package
java -jar target/rules-quarkus-stateful-runner.jar
```

or on windows

```sh
mvn clean package
java -jar target\rules-quarkus-stateful-runner.jar
```

### Package and Run using Local Native Image
Note that this requires GRAALVM_HOME to point to a valid GraalVM installation

```sh
mvn clean package -Pnative
```

To run the generated native executable, generated in `target/`, execute

```sh
./target/rules-quarkus-stateful-runner
```

Note: This does not yet work on Windows, GraalVM and Quarkus should be rolling out support for Windows soon.

## Example Usage

Once the service is up and running, you can use the following example to interact with the service.

### POST /event

Post "event":

```sh
curl -X POST "http://localhost:8090/event" -H  "accept: */*" -H  "Content-Type: text/plain" -d "hello"
```


## Deploying with Kogito Operator

In the [`operator`](operator) directory you'll find the custom resources needed to deploy this example on OpenShift with the [Kogito Operator](https://docs.jboss.org/kogito/release/latest/html_single/#chap_kogito-deploying-on-openshift).
