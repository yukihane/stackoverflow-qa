import { UAParser } from "ua-parser-js";

export const hello = () => {
  const elm = document.getElementById("client");
  if (elm) {
    const ua = navigator.userAgent;
    const parser = new UAParser(ua);
    elm.innerText = parser.getBrowser().name || "unknown";
  }
};
