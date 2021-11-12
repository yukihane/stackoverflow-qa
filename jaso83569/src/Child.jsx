import { useEffect } from "react";

const Child = ({ test }) => {
  const message = "ハローワールド";
  useEffect(() => test(message), [test]);
  return <p></p>;
};
export default Child;
