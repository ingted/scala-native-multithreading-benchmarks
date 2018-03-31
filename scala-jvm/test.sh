#! /bin/bash
mkdir -p results

N=64
i=5
for t in $(seq 1 1 $N)
do
  echo "running $i iterations on $t threads"
  sbt "run --threads $t --iterations $i --out results/jvm_${i}_$t.csv" 2>&1 | tee results/jvm_${i}_$t.log
done

cat results/jvm_${i}_*.csv > results/summary_jvm_${i}.csv