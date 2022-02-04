type Prefix = "foo";
type Postfix = "1" | "2";
type ValueType = `${Prefix}_${Postfix}`;

const prefix = (value: Postfix): ValueType => {
  const prefix = "foo";
  return `${prefix}_${value}`;
};

const process = (i: number): ValueType => {
  if (i > 0) {
    return prefix("1");
  } else {
    return prefix("2");
  }
};

console.log(process(10)); // "foo_1"
console.log(process(-10)); // "foo_2"
