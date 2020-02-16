draft です。

多くの言語でそのような機能は[Foreign Function Interface(FFI)](https://ja.wikipedia.org/wiki/Foreign_function_interface)と呼ばれているので、FFI + design, principle, concept あたりをキーワードに検索することになると思います。

具体的なイディオムとして見つけられたのは [opaque pointer](https://en.wikipedia.org/wiki/Opaque_pointer) だけでした。

また、自分が疑問に思っていたことと同じ方向の記事として、次のようなものがありました。

- [When &amp; How to Use an FFI (Foreign Function Interface)](https://spin.atomicobject.com/2013/02/15/ffi-foreign-function-interfaces/)

加えて、質問の当初の趣旨に反して実装言語依存のものになるのですが、

- [Crossing the Rust FFI frontier with Protocol Buffers - Mozilla Hacks - the Web developer blog](https://hacks.mozilla.org/2019/04/crossing-the-rust-ffi-frontier-with-protocol-buffers/)

という記事内容は、自分が問題としている領域とかなり近く、ここで説明されているライブラリのリポジトリは掘ってみる価値があるのではないかな、と考えています。

FFI の話題では、既存のプログラム資産を利用するために行う、というものも多い(FFI API をデザインする余地が無く、既存の API に合わせることができるかが関心の対象になる)ですが、Mozilla/Rust 関連の記事だとマルチプラットフォームのために新規作成機能も FFI を利用して実装していく、というようなものが多く、参考になりそうだな、と感じています。

---

(以下独自研究成分多めです。[要出典]タグを各文末に補完しながらお読みください)

今回、「呼び出し元」「呼び出し先」という 2 つの立場のモジュールが登場しています。
これら 2 つのモジュールが協調動作するとき、2 つの類型に分類できるかなと考えます。

- 呼び出し元が生成したデータを呼び出し先が受け取(り、処理す)る
- 呼び出し先が生成したデータを呼び出し元が受け取(り、処理す)る

以降、このデータのことをコンテンツと呼称しますが、上記はつまり、2 種類の役割

- コンテンツ生産者
- コンテンツ消費者

があり、一方の立場がどちらかの役割を担い、他方の立場が別の役割を担うことになることを意味します。

さて、プログラム上でコンテンツを取り扱うために考慮すべき大きな事項があります。それがメモリ領域(コンテンツを格納する容器)の確保です。また、この容器を破棄する処理も必要になります。

まず、容器を作成するのは誰が適任なのかを考えてみます。
…コンテンツ生産者が必要なサイズの容器を用意する、というのがどう考えても適切に思われます。
(考えてみると、古典的プログラムバグであるところのバッファオーバランも、コンテンツ生産者以外が容器の作成を行っているという歪な役割分担が原因ですね。)

C 言語からプログラミングを始めた者からすると [`scanf`](https://linuxjm.osdn.jp/html/LDP_man-pages/man3/scanf.3.html)なんかはかなり初期に登場するのでこれが自然な形のように思い込んでいましたが、よくよく考えてみると本当に自然なのは[`readline`](https://tiswww.case.edu/php/chet/readline/readline.html#SEC24)の方だった、という。
