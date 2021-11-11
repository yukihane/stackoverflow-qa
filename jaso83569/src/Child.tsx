const Child = (props) => {
  const message = "ハローワールド";
  return <p>{props.test(message)}</p>;
};
export default Child;
