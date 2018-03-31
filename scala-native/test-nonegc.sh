#! /bin/bash
mkdir -p results

N=64
i=5
export SCALANATIVE_GC=none
sbt clean "run --threads 1 --iterations 1" 2>&1 | tee results/nonegc_build.log
for t in $(seq 1 1 $N)
do
  echo "running $i iterations on $t threads"
  target/scala-2.11/scala-native-out --threads $t --iterations $i --out results/nonegc_${i}_$t.csv 2>&1 | tee results/nonegc_${i}_$t.log
done

cat results/nonegc_${i}_*.csv > results/summary_nonegc_${i}.csv
