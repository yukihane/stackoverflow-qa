import React, { useState } from "react";
import { Child } from "./Child.js";

const App = () => {
  const [child, setChild] = useState("");
  return (
    <div>
      　<Child test={setChild} />　{child}
    </div>
  );
};
export default App;
