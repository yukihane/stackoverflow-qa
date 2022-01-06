const format = "吾輩はkindである。名前はmy_name。";
const variables = [
  ["kind", "猫"],
  ["my_name", "まだ無い"],
];

const text = variables.reduce((s, e) => s.replace(...e), format);
//// ↓ s.replace(...e); の変数 s, e を具体的な値に置き換えると:
// "吾輩はkindである。名前はmy_name。".replace("kind", "猫");
// "吾輩は猫である。名前はmy_name。".replace("my_name", "まだ無い");

console.log(text);
