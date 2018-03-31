#! /bin/bash

echo "SYSTEM INFO"
./dump-sysinfo.sh
echo "Scala on JVM"
cd scala-jvm && ./test.sh
cd ..

echo "Scala Native"
cd scala-native && ./test-boehm.sh; ./test-nonegc.sh
cd ..

echo "Making the report directory"
mkdir -p report
cp -v results/* report/
cp -rv scala-jvm/results report/scala-jvm
cp -rv scala-native/results report/scala-native

