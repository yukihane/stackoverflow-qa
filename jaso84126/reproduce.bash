#!/bin/bash

set -eux

mkdir workrepo
cd workrepo
git init -b main
git commit --allow-empty -m init
echo '* text eol=crlf' > .gitattributes
git add .gitattributes && git commit -m 'add .gitattributes'
git checkout -b feature
git rm .gitattributes && git commit -m 'remove .gitattributes'
echo -e 'hello\nworld' | unix2dos > hello.txt
git add hello.txt && git commit -m 'add hello.txt with CRLF'
GIT_SEQUENCE_EDITOR="sed -i '1d'" git rebase -i main
git checkout -f main
git merge --no-ff --no-edit feature
