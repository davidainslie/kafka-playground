# Kafka Playground in Scala #

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Along with
any pull requests, please state that the contribution is your original work and that you license
the work to the project under the project's open source license. Whether or not you state this
explicitly, by submitting any copyrighted material via pull request, email, or other means you
agree to license the material under the project's open source license and warrant that you have the
legal authority to do so.

## License ##

This code is open source software licensed under the
[MIT](https://opensource.org/licenses/MIT) license.

## Installation requirements ##
On Mac:
```
$ brew update && brew install scala && brew install sbt && brew install kubernetes-cli && brew install kubectl && brew cask install virtualbox docker minikube
```

## Unit Testing ##
```
$ sbt test
```

## Integration Testing ##
```
$ sbt it:test
```

## Gatling ##
Gatling tests can act as performance tests and acceptance tests (thus providing regression tests).
```
$ sbt gatling-it:test
```

## Docker Compose ##
Using "sbt docker compose" plugin.

To use locally built images for all services defined in the Docker Compose file instead of pulling from the Docker Registry use the following command:

```
$ sbt dockerComposeUp
```

To shutdown all instances started from the current project with the Plugin enabled run:

```
$  sbt dockerComposeStop
```

Docker Compose is configured to start Zookeeper, Kafka and this application/service.

And easy way to test/check is to create a test publisher and consumer using **kafkacat** - for a Mac install by:
```
$ brew install kafkacat
```

Then start a test publisher and publish events to kafka by:
```
$ kafkacat -P -b localhost:9092 -t test
scooby
doo

```

Which can be consumed by:
```
$ kafkacat -C -b localhost:9092 -t test
scooby
doo

```