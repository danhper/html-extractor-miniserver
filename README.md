# html-extractor

A tiny HTTP server that returns the content of a webpage given a URL.
The project uses [boilerpipe](https://code.google.com/archive/p/boilerpipe/).

You only need Java installed to run the server.

## Running the server

Grab the jar from the release page and run

```
java -jar html-extractor.jar
```

## Sample usage

```
curl localhost:8080/extract/https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FParsing
```

## Building

You will need [sbt](http://www.scala-sbt.org/) to build the project.
You can simply compile with `sbt compile` or create a JAR with `sbt assembly`.
