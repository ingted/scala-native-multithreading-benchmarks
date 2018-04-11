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
cp -v scala-jvm/results/sumary_*.csv report/
cp -v scala-native/results/sumary_*.csv report/

