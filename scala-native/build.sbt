scalaVersion := "2.11.11"

ScalaNativePlugin.projectSettings

lazy val gcSettings =
  if (!System.getenv.containsKey("SCALANATIVE_GC")) {
    println("Using default gc")
    Seq.empty
  } else {
    val gc = System.getenv.get("SCALANATIVE_GC")
    println(s"Using gc based on SCALANATIVE_GC=$gc")
    Seq(nativeGC := gc)
  }

gcSettings

nativeMode := "release"

enablePlugins(ScalaNativePlugin)
