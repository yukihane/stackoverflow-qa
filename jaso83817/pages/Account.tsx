import type { NextPage } from "next";
import { useState } from "react";

const Account: NextPage = () => {
  const [title, setTitle] = useState("Title");

  function chnageTitle() {
    setTitle("Change title");
  }

  return (
    <div>
      <h1>{title}</h1>
      <button onClick={chnageTitle}>Change Title</button>
    </div>
  );
};

export default Account;
