function controlselect() {
  let elements = document.getElementsByClassName("disselect");
  let len = elements.length;
  var sele_val = document.getElementById("other").value;
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

controlselect();
