#! /bin/bash

rm -rv results
rm -rv report
rm -rv scala-jvm/results
rm -rv scala-native/results
echo $(cd scala-jvm && sbt clean)
echo $(cd scala-native && sbt clean)
