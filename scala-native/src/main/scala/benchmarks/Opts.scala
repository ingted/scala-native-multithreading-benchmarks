package benchmarks

final class Opts(val format: Format = TextFormat,
                 val outFile: Option[String] = None,
                 val iterations: Int = 5,
                 val threadCount: Int = Runtime.getRuntime.availableProcessors()) {
  def copy(format: Format = format,
           outFile: Option[String] = outFile,
           iterations: Int = iterations,
           threadCount: Int = threadCount): Opts =
    new Opts(format, outFile, iterations, threadCount)
}

object Opts {
  def apply(args: Array[String]): Opts = {
    def loop(opts: Opts, args: List[String]): Opts = args match {
      case "--format" :: format :: rest =>
        loop(opts.copy(format = Format(format)), rest)
      case "--out" :: file :: rest =>
        loop(opts.copy(outFile = Some(file)), rest)
      case "--threads" :: threads :: rest =>
        loop(opts.copy(threadCount = threads.toInt), rest)
      case "--iterations" :: iterations :: rest =>
        loop(opts.copy(iterations = iterations.toInt), rest)
      case other :: _ =>
        throw new Exception("unrecognized option: " + other)
      case Nil =>
        opts
    }
    loop(new Opts(), args.toList)
  }
}
