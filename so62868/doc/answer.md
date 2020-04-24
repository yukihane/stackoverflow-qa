多くの言語でそのような機能は[Foreign Function Interface(FFI)](https://ja.wikipedia.org/wiki/Foreign_function_interface)と呼ばれているので、FFI + design, principle, concept あたりをキーワードに検索することになると思います。

質問に対する直接的な回答として、具体的なイディオムとして見つけられたのは [opaque pointer](https://en.wikipedia.org/wiki/Opaque_pointer) くらいでした。

---

他には、自分が疑問に思っていたことと同じ方向の記事として、次のようなものがありました。

- [When &amp; How to Use an FFI (Foreign Function Interface)](https://spin.atomicobject.com/2013/02/15/ffi-foreign-function-interfaces/)

加えて(、質問の当初の趣旨に反して実装言語依存のものになるのですが)、

- [Crossing the Rust FFI frontier with Protocol Buffers - Mozilla Hacks - the Web developer blog](https://hacks.mozilla.org/2019/04/crossing-the-rust-ffi-frontier-with-protocol-buffers/)

という記事内容は、自分が問題としている領域とかなり近く、ここで説明されているライブラリのリポジトリは詳細を見てみる価値があるのではないかな、と考えています。

現時点の FFI の話題は、既存のプログラム資産を利用するために行う、というものが比較的多い(FFI API をデザインする余地が無く、既存の API に合わせることができるかが関心の対象になる)印象を受けています。
それとは異なり、Mozilla が Rust で行おうとしているのは、マルチプラットフォームのために新規作成機能も FFI を利用して実装していくというものなので、自分にとって参考になりそうな情報が多そうだ、と感じました。

---

(以下、概ね出典のない[独自研究](https://ja.wikipedia.org/wiki/Wikipedia:%E7%8B%AC%E8%87%AA%E7%A0%94%E7%A9%B6%E3%81%AF%E8%BC%89%E3%81%9B%E3%81%AA%E3%81%84)です。)

今回、「呼び出し元」「呼び出し先」という 2 つの立場のモジュールが登場しています。
これら 2 つのモジュールが協調動作するとき、2 つの類型に分類できるかなと考えます。

- 呼び出し元が生成したコンテンツを呼び出し先が受け取り、処理する
- 呼び出し先が生成したコンテンツを呼び出し元が受け取り、処理する

(画像 01)

ここからコンテンツを格納するメモリ領域(以降、作図の都合上容器と呼称します)の確保と破棄について考えていきます。

まず、容器を作成するのは誰が適任なのかを考えてみると、コンテンツ生産者が必要なサイズの容器を用意する、というのがどう考えても適切に思われます(以下、*基本形*と呼称)。

(画像 02)

コンテンツ消費者は一般的にコンテンツの大きさがわからないので適切な容器を作成するのが困難で、小さすぎるとバグ(バッファオーバラン)になり、大きすぎると効率が低下します。

それではなぜ、呼び出し先がコンテンツ生産するような C 言語の API (例えば[`scanf`](https://linuxjm.osdn.jp/html/LDP_man-pages/man3/scanf.3.html)や[`strcpy`](https://linuxjm.osdn.jp/html/LDP_man-pages/man3/strcpy.3.html))はコンテンツ消費者である呼び出し元が容器を用意する前提(以降、*容器先渡し方式*と呼称)なのか。
これは容器としてスタック領域を利用したいという C 言語特有の要求によるものではないかと思われます。
FFI について考えると、スタック領域を意識しない(意識できない)言語も多く、これについてさほど強い要求は無いのではと考えます。

ただし、スタック領域利用のことを考えないとしても、呼び出し先のコンテンツ生産者に容器作成を任せたくない状況はあり得るでしょう。
呼び出し先のコンテンツ生産者に対してコンテンツ生成を高頻度で依頼するような状況で、容器作成を都度行わなくとも前回のものを使い回せる(必要な容器の大きさが固定で、現在の容器の中身は無くなっても良い)、というような場合です。
この場合には、あらかじめ容器を作成して、コンテンツ要求の関数で*容器先渡し*を行い容器作成処理を省略したくなるのでは無いかと考えます。
(グラフィック処理なんかが該当すのでは、思っていますが、確認できていません)

パフォーマンス上の要請で行うことになるので、自然にこの形になった、という状況は無く、意図を持って*基本形*から*容器先渡し方式*に変形することになるのではないでしょうか。

(画像 03)

次に、容器を破棄するのが適切のは誰かと言うと、これもあまり考える余地がなくコンテンツ消費者がコンテンツを消費し不要になった時点で行うのが自然で、つまりコンテンツ消費者が行う、ということになるかと思います。
ただし、容器を破棄する処理の実装と容器を作成する処理の実装は同じ側が行っているはずで、API 境界をまたぐ呼び出しが発生する場合もあります。

(画像 04)

質問文には容器の破棄を忘れる(リーク)という懸念もありました。
これについては、調べた限りでは、たしかにそのとおりだが、言語に備わっているデストラクタ相当機能(Java の `try-finally`(Project Panama では [`Scope`](https://download.java.net/java/early_access/panama/docs/api/java.base/java/foreign/Scope.html)の`try-with-resources`) や Go だと [`defer`](https://blog.golang.org/c-go-cgo))でリークを防いでいくことで対応可能、というのが一般的な考え方のようです。

コールバック方式について。
必ずしも利用を避けるべきとは言えないが、前述の*基本形*でなくコールバック方式を用いるのであればちゃんとした意図が必要(*容器先渡し方式*と同じように)なのかな、という感想を持ちました。
言語や FFI ライブラリ実装によって考慮すべき事項が異なり、机上で思い浮かべられることより実際の難易度は高そうに感じられます。

なお、(既存資産の再利用文脈以外での)コールバック方式についての言及は、調べた限りでは、冒頭にリンクしたものともうひとつの合計 2 つだけでした。

- [When &amp; How to Use an FFI (Foreign Function Interface)](https://spin.atomicobject.com/2013/02/15/ffi-foreign-function-interfaces/)

> ##### Making a C Library FFI Friendly
>
> 4. Keep callback signatures simple, shallow, and well-documented. This is especially important if callbacks are necessary to use the library’s core functionality.

- YouTube: [Nikita Baksalyar — All you need to know about the Rust FFI (Rust Hungary #2, 2017-10-24), 28:15 より](https://youtu.be/ctffjzdgGvc?t=28m15s) , summary は [34:40 より](https://youtu.be/ctffjzdgGvc?t=34m40s)

> - Callbacks ar not ideal, but they work

まとめると、_基本形_ がベースになり、_容器先渡し方式_, _コールバック方式_ は明確な意図を持って _基本形_ から変形すべき、ということになります。
