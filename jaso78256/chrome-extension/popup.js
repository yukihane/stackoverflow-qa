// When the button is clicked, inject setPageBackgroundColor into current page
changeColor.addEventListener("click", async () => {
  let [tab] = await chrome.tabs.query({ active: true, currentWindow: true });

  chrome.scripting.executeScript({
    target: { tabId: tab.id },
    function: setPageBackgroundColor,
  });
});

// The body of this function will be executed as a content script inside the
// current page
function setPageBackgroundColor() {
  var oReq = new XMLHttpRequest();
  oReq.open("POST", "http://localhost:8080/", true);
  oReq.onload = function (oEvent) {
    // Uploaded.
  };

  // var blob = new Blob([data], { type: "text/plain" });
  const obj = { hello: "world" };
  const blob = new Blob([JSON.stringify(obj, null, 2)], {
    type: "text/plain",
  });

  oReq.send(blob);

  chrome.storage.sync.get("color", ({ color }) => {
    document.body.style.backgroundColor = color;
  });
}
