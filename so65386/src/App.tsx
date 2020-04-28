import React, { FC, useState } from "react";
import Switch from "@material-ui/core";

interface IState {
  numbers: boolean;
  symbol: boolean;
  texxt: boolean;
}

const index: FC = () => {
  const [state, setState] = useState<IState>();

  const changeState = (key: IState) => {
    console.log(key);
    // setStateでうまくstateを変更できない
    // setState({ ...state, ...{ key: !key }});
  };

  //  <Switch
  //   checked={numberState}
  //   onChange={(e) => changeState({ numberState: e.target.checked })}
  //  />
  //  <Switch
  //   checked={textState}
  //   onChange={(e) => changeState({ textState: e.target.checked })}
  //  />
  //  <Switch
  //   checked={symbolState}
  //   onChange={(e) => changeState({ symbolState: e.target.checked })}
  //  />
  return <div></div>;
};
export default index;
