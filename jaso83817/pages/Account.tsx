import type { NextPage } from "next";

const Account: NextPage = () => {
  let title = "Title";

  function chnageTitle() {
    title = "Changed Title";
  }

  return (
    <div>
      <h1>{title}</h1>
      <button onClick={chnageTitle}>Change Title</button>
    </div>
  );
};

export default Account;
