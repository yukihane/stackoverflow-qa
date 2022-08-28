function test(a, b, c) {
  a[b] = c % 2 === 0 ? "グースー" : a[b];
}

const a = ["キスー", "キスー"];

test(a, 0, 0);
test(a, 1, 1);

console.log(a);
