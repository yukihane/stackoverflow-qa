const Child = (props: {
  test: React.Dispatch<React.SetStateAction<string>>;
}) => {
  const message = "ハローワールド";
  return <p>{() => props.test(message)}</p>;
};
export default Child;
