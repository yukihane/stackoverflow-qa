type Draft<T> = { [K in keyof T]: T[K] | null };
type AtLeastOne<T, U = { [K in keyof T]: Pick<T, K> }> = Draft<T> & U[keyof U];

type FullExampleType = {
  foo: string;
  bar: string;
};

type ExampleType = AtLeastOne<FullExampleType>;

const v1: ExampleType = { foo: "foo_val", bar: "bar_val" }; // OK
const v2: ExampleType = { foo: "foo_val", bar: null }; // OK
const v3: ExampleType = { foo: null, bar: "bar_val" }; // OK
const v4: ExampleType = { foo: null, bar: null }; // NG
