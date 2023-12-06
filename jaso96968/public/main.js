document.addEventListener("DOMContentLoaded", (event) => {
  function reqListener() {
    console.log(this.responseText);
  }

  const req = new XMLHttpRequest();
  req.addEventListener("load", reqListener);
  req.open("GET", "http://localhost:8080/");
  req.send();
});
