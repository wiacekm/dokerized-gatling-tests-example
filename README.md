# Dockerized gatling tests example

Simple example how to wrap gatling test with docker container
Building image:
```shell script
sbt clean compile publishLocal docker:publishLocal
```

Example run docker command to use it:
```shell script
docker run \
  -v "$(pwd):/opt/log/" \
  io/github/michalw/utilities/dockerized-gatling-tests-example:latest
```
