import React from "react";
import "./App.css";

interface CounterProps {
  name: string;
  count: number;
  onClickPlus: () => void;
  onClickMinus: () => void;
}

const Counter = (props: CounterProps) => {
  const handlePlus = () => {
    props.onClickPlus();
    console.log(props.count);
    // this.forceUpdate();
  };

  const handleMinus = () => {
    props.onClickMinus();
    console.log(props.count);
    // this.forceUpdate();
  };

  return (
    <div>
      <h3>{props.name}の個数</h3>
      <button onClick={handlePlus}>プラス！</button>
      <div>{props.count}個</div>
      <button onClick={handleMinus}>マイナス！</button>
    </div>
  );
};

interface State {
  counterCount: number;
}

const initState: State = {
  counterCount: 5,
};

const reducer = (state: State = initState, action: string): State => {
  if (action === "PLUS") {
    return { counterCount: state.counterCount + 1 };
  } else if (action === "MINUS") {
    return { counterCount: state.counterCount - 1 };
  }
  return state;
};

const handlePlus = (dispatch: React.Dispatch<any>) => {
  // console.log("handlePlus", state.counterCount);
  dispatch("PLUS");
};

const handleMinus = (dispatch: React.Dispatch<any>) => {
  // console.log("handleMinus", state.counterCount);
  dispatch("MINUS");
};

const Counters = () => {
  const [state, dispatch] = React.useReducer(reducer, initState);
  return (
    <div>
      <Counter
        name="りんご"
        count={state.counterCount}
        onClickPlus={() => handlePlus(dispatch)}
        onClickMinus={() => handleMinus(dispatch)}
      />
    </div>
  );
};

export default Counters;
