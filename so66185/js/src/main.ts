// 大筋は次を参考にした: https://stackoverflow.com/a/47082428/4506703

// Angular styleのクラス型定義: https://stackoverflow.com/a/52183279/4506703
interface Constructable<T> extends Function {
  new (...args: any[]): T;
}

export abstract class Factory {
  static factories: Constructable<Factory>[] = [];
  static getFactory(className: string): Factory | undefined {
    const factory = this.factories.find((e) => e.name === className);
    if (factory) {
      return new factory();
    } else {
      return undefined;
    }
  }
  // do something
}

export class ListFactory extends Factory {
  // do something
}

export class TableFactory extends Factory {
  // do something
}

// ファクトリ具象クラスの登録
// Javaのクラスローダのようなものはないので自前で管理する
Factory.factories.push(ListFactory, TableFactory);

// コマンドラインから'ListFactory'などの文字列を受け取り動的に処理を進めたい
const className: string = process.argv[2];
const f = Factory.getFactory(className);
// do something
