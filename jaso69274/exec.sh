#!/bin/bash
set -eu

mkdir myrepo
cd myrepo

git init
git commit --allow-empty -m init

# 1.ブランチfeatureで作業開始(hello.txt作成)
git checkout -b feature
git tag start-feature
echo 'Hello!' > hello.txt
git add hello.txt
git commit -m hello

# 2.ブランチmasterにfeatureをマージしたけれど...
git checkout master
git merge --no-ff --no-edit feature

# 3.作業途中だったことに気づいてrevert
git revert --no-edit -m 1 @

# 4.あらためてfeatureで作業(world.txt作成)
git checkout feature
echo 'World!' > world.txt
git add world.txt
git commit -m world

# 5.featureでの作業が完了したのでmasterにマージ
git checkout master
git merge --no-ff --no-edit feature

# hello.txt とworld.txtができていてほしい...
# けれど存在するのはworld.txtだけ
ls -l
