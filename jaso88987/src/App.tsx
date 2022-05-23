import { invoke } from "@tauri-apps/api";
import React, { ChangeEvent, useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  const submit = () => {
    invoke<string>("get_rss")
      .then((resp) => {
        console.log("recv:" + resp);
        setMessage(resp);
      })
      .catch((e) => setMessage(e));
  };

  return (
    <div>
      <div style={{ padding: 10 }}>
        <input type="button" value="送信" onClick={submit} />
      </div>
      <div style={{ padding: 10 }}>
        <input
          readOnly
          type="text"
          name="response"
          id="response"
          value={message}
          style={{ width: 300 }}
        />
      </div>
    </div>
  );
}

export default App;
