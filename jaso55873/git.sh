#! /bin/sh

set -eux

mkdir test-repo
cd test-repo
git init --initial-branch=master
git commit --allow-empty -m init
echo 'Hello' > sample1.txt
git add sample1.txt
git commit -m 'commit sample1.txt to master branch'
git checkout -b test
git rm sample1.txt
echo 'Good by' > sample2.txt
git add sample2.txt
git commit -m 'commit to test branch'
git checkout master
# 本来は test ブランチで行った変更が master に反映される
# すなわち sample1.txt が削除され sample2.txt が追加されるはず
git merge --no-ff --no-commit test
# だが、 sample1.txt の削除を無かったことにできてしまう
git reset -- sample1.txt
git -c core.editor=true merge --continue # https://stackoverflow.com/a/56814897/4506703
git reset --hard HEAD
ls
# test ブランチをマージした master ブランチに sample1.txt が存在する
