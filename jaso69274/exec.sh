#!/bin/bash
set -eux

mkdir myrepo
cd myrepo

git init
git commit --allow-empty -m init

# ブランチfeatureで作業開始
git checkout -b feature
echo 'Hello!' > hello.txt
git add hello.txt
git commit -m hello

# ブランチmasterにfeatureをマージしたけれど...
git checkout master
git merge --no-ff --no-edit feature

# 作業途中だったことに気づいてrevert
git revert --no-edit -m 1 @

# あらためてfeatureで作業
git checkout feature
echo 'World!' > world.txt
git add world.txt
git commit -m world

# featureでの作業が完了したのでmasterにマージ
git checkout master
git merge --no-ff --no-edit feature

# 最初にmergeしてその後revertしたhello.txtが消えている
