let num;
let myTime;
let n;
let tf;

$(function () {
  tf = true;
  $("#bt").click(function () {
    if (tf == true) {
      tf = false;
      num = 0;
      myTime = setInterval(nemui, 1000);
    }
  });

  $("#bt2").click(function () {
    if (tf == false) {
      tf = true;
      clearInterval(myTime);
    }
  });
});

function nemui() {
  if (num == 10) {
    console.log("おわり");
    clearInterval(myTime);
  } else {
    console.log(num);
    num++;
  }
}
