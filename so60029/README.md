## これは何？

https://ja.stackoverflow.com/q/60029/2808
サンプル実装


## 確認方法

### サーバ起動

    mvn spring-boot:run

### 確認

#### 正常データ送信

    curl -i -X POST -H 'Content-Type: application/json' http://localhost:8080 -d '{"value":"50"}'

#### NGデータ送信

    curl -i -X POST -H 'Content-Type: application/json' http://localhost:8080 -d '{"value":"NG"}'
