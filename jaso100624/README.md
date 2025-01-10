# [Reactのビルドエラーが表示されない](https://ja.stackoverflow.com/q/100624/2808)

`npm run dev` したとき、未定義変数を利用してもプレビュー画面にエラーが出ない、という問題。
(ちなみにdevtoolsのコンソールには実行時エラーとして出力されている)

この挙動は意図されたもの。

[特徴 | Vite > TypeScript](https://ja.vite.dev/guide/features#typescript) によると:
> Vite は `.ts` ファイルのトランスパイルを行うだけで、型チェックは行わないことに注意してください。型チェックは IDE やビルドプロセスで行われることを想定しています。
> 
> Vite が変換処理の一部として型チェックを行わないのは、この 2 つのジョブが根本的に異なる動作をするからです。トランスパイルはファイル単位で行うことができ、Vite のオンデマンドコンパイルモデルと完全に調和しています。これに対して、型チェックはモジュールグラフ全体についての知識が必要です。Vite の変換パイプラインに型チェックを組み込むと、必然的に Vite の利点であるスピードが損なわれてしまいます。
> 
> Vite の仕事は、ソースモジュールをできるだけ速くブラウザーで実行できる形にすることです。

また、対応として
> - 開発中、IDE のヒント以上が必要な場合は、別プロセスで `tsc --noEmit --watch` を実行するか、型エラーをブラウザーに直接報告させたい場合は [vite-plugin-checker](https://github.com/fi3ework/vite-plugin-checker) を使用することをおすすめします。

とある。

今回の質問では vite-plugin-checker は導入済みだったが、デフォルト設定ではチェックされない問題を検出したいということだったので [`buildMode` オプション](https://vite-plugin-checker.netlify.app/checkers/typescript.html#configuration) を `true` に追加設定する必要があった。

```ts
// vite.config.ts
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import checker from "vite-plugin-checker";

export default defineConfig({
  plugins: [
    react(),
    checker({
      typescript: {
        buildMode: true,
      },
    }),
  ],
});
```
