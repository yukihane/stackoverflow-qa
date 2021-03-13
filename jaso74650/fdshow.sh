#!/bin/sh

pid=$(jps | grep FileInputDemo | cut -d ' ' -f 1)
fd=$(ls -l /proc/$pid/fd/ | grep demo.out | cut -d ' ' -f 10)

# ファイル行数出力
# rmで削除しても削除してもプロセスが書いた内容が反映され続けるのが確認できる
cat "/proc/$pid/fd/$fd" | wc -l
