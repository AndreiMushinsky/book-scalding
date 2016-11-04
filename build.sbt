name := "book-scalding"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.twitter" %% "scalding-core" % "0.16.1-SNAPSHOT"

libraryDependencies += "org.apache.hadoop" % "hadoop-core" % "1.2.1" % "provided"

assemblyJarName in assembly := "book-scalding.jar"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) => {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
}
