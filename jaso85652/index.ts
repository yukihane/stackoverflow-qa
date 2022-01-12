const objectMap = (obj, fun) =>
  Object.fromEntries(Object.entries(obj).map(fun));

objectMap({ a: 2, b: 4 }, ([key, val]) => [key, val * 2]); // {a: 4, b: 8}
