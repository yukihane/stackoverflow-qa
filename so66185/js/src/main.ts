export abstract class Factory {
  static getFactory(className: string): Factory {
    const factory: Factory = /* new 'className'() のようなことがしたい */;
    return factory;
  }
  // do something
}

export class ListFactory extends Factory {
  // do something
}

export class TableFactory extends Factory {
  // do something
}

// コマンドラインから'ListFactory'などの文字列を受け取り動的に処理を進めたい
const className: string = process.argv[2];
const f = Factory.getFactory(className);
// do something
