# Scala native multithreading benchmarks
Multi-threading benchmarks to compare Scala native with Scala on JVM by running benchmarks with (1 to 64) threads. The results are produced as a CSV file.

This project is based opon benchmarks module in the Scala native project.
## Requirements
* [Scala-native](https://github.com/scala-native/scala-native) project checked out on `topic/multithreading`
* JDK and dependencies installed see http://www.scala-native.org/en/latest/user/setup.html
* Linux (may also work on other systems, but I have not tested that)

## Usage
1. Build your scala-native project with `sbt rebuild`.
2. Create a full report with tests results and system configuration: `./full-report.sh`
Alternatively run individual test suites with `./test.sh` scripts in the subprojects. Or run with specific thread count with `sbt run`

## Options for sbt run
- `--format [text, csv]` Specifies the output format for stdout. Does not affect outfile. **default:** `text`
- `--out [file]` Specifies the csv output file for results. The old file is overwriten.
- `--threads [number]` How many threads should be created. Uses all available (virtual) cores by default.
- `--iterations [number]` How many times the should the test be repeated. **default:** `5`
- `--futures` use `Future`s instead of threads.

The garbage collector can be set by `export SCALANATIVE_GC=boehm` or `export SCALANATIVE_GC=none`

## Benchmarks
- Finding Pi with Montecarlo simulation using threads. Number of points = 3 000 000
- Finding Pi with Montecarlo simulation using a `Future` per point. Number of points = 200 000. Enable with `--futures`