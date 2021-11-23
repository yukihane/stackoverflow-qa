// 引数で要素のグループを指定する
function controlselect(target) {
  let elements = target.getElementsByClassName("disselect");
  let len = elements.length;
  // id は使えないので class に変更
  var sele_val = target.getElementsByClassName("other")[0].value;
  if (sele_val === "その他") {
    for (let i = 0; i < len; i++) {
      elements.item(i).removeAttribute("disabled");
    }
  } else {
    for (let i = 0; i < len; i++) {
      elements.item(i).setAttribute("disabled", true);
    }
  }
}

document.addEventListener("DOMContentLoaded", () => {
  const targets = ["elements1", "elements2", "elements3"];
  for (let t of targets) {
    const div = document.getElementById(t);
    div
      .getElementsByClassName("other")[0]
      .addEventListener("change", () => controlselect(div));
    controlselect(div);
  }
});
