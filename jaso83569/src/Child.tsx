import { useEffect } from "react";

type Props = {
  test: React.Dispatch<React.SetStateAction<string>>;
};
const Child = ({ test }: Props) => {
  const message = "ハローワールド";
  useEffect(() => test(message), [test]);
  return <p></p>;
};
export default Child;
