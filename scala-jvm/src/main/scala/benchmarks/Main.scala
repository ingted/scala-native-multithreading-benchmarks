package benchmarks

import java.io.PrintWriter
import java.lang.System.exit

import montecarlo.{PiFuturesBenchmark, PiMultiThreadBenchmark}

object Main {
  def main(args: Array[String]): Unit = {
    val opts = Opts(args)
    val benchmarks = if (opts.useFutures) {
      Seq(new PiFuturesBenchmark(opts.threadCount))
    } else {
      Seq(new PiMultiThreadBenchmark(opts.threadCount))
    }


    val results = benchmarks.map { bench =>
      bench.loop(opts.iterations)
      bench.loop(opts.iterations)
    }
    val success = results.forall(_.success)

    println(opts.format.show(results))

    opts.outFile.foreach{
      fileName =>
        val writer = new PrintWriter(fileName)
        writer.println(CSVFormat.show(results))
        writer.close()
    }

    if (!success) exit(1)
  }
}
