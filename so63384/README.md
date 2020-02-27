## これは何?

- https://ja.stackoverflow.com/q/63384/2808

[MapStruct](https://mapstruct.org/) を利用してオブジェクトのマージ処理を行うサンプルです。

[`src/main/java/`](./src/main/java/)以下の2ファイルを参照してください。

MapStructはMapping Framework などとカテゴライズされるライブラリで、次のページに他のプロダクトも含め紹介があります:

- [Performance of Java Mapping Frameworks](https://www.baeldung.com/java-performance-mapping-frameworks) - Baeldung


## 使い方

    ./mvnw clean compile exec:java

Lombok, MapStructがアノテーションプロセッシングでコード生成を行うのでMaven経由で実行してください。
