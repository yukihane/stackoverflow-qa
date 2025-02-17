# [lombokをテストコードで使用するには](https://ja.stackoverflow.com/q/100819/2808)

## 事象

`dependencies` に lombok を指定しても、テスト時に lombok が機能しない

## 調査

再現しない。

```bash
./mvnw clean test
```

で、テストコードでもlombokが生成したコンストラクターやgetterが利用できている。
