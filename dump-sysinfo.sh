#! /bin/bash
mkdir -p results

uname -a 2>&1 | tee results/uname.txt
lsb_release -a 2>&1 | tee results/lsb_release.txt
lscpu 2>&1 | tee results/lscpu.txt
sudo dmidecode --type memory 2>&1 | tee results/dmidecode-memory.txt

java -version 2>&1 | tee results/java-version.txt
javac -version 2>&1 | tee results/javac-version.txt
