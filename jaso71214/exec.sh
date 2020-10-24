#!/bin/bash
set -eu

git init
git commit --allow-empty -m init

git checkout -b local-branch
for i in {1..4} ; do
  git commit --allow-empty -m "ローカルコミット${i}"
done

git checkout @~3
git checkout -b remote-branch
for i in {1..3} ; do
  git commit --allow-empty -m "リモートコミット${i}"
done

git checkout local-branch
git merge --no-edit remote-branch

for i in {5..7} ; do
  git commit --allow-empty -m "ローカルコミット${i}"
done
