#!/bin/bash

set -eux

pushd librust
cargo build --release
popd

## https://github.com/eqrion/cbindgen
## ↓で自動生成したものは少し冗長なので手で削ったものをcommit
# cbindgen -l c -o bridges/greeter.h librust

## https://openjdk.java.net/projects/panama/
jextract \
-L librust/target/release/ \
-l greeter \
-o bridges/greeter.jar \
./bridges/greeter.h

pushd mainjava
javac -cp ../bridges/greeter.jar ./src/Main.java
popd

cat << EOF


usage: LD_LIBRARY_PATH=./librust/target/release java -cp bridges/greeter.jar:mainjava/src/ Main

EOF
