type ObjectMap = <V, R>(
  obj: { [s: string]: V } | ArrayLike<V>,
  fun: (arg: [string, V]) => [PropertyKey, R]
) => { [s: string]: R };

const objectMap: ObjectMap = (obj, fun) =>
  Object.fromEntries(Object.entries(obj).map(fun));

const result = objectMap({ a: 2, b: 4 }, ([key, val]) => [key, val * 2]);
console.log(result); // {a: 4, b: 8}
