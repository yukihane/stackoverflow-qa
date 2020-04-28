import React, { FC, useState } from "react";
import { Switch } from "@material-ui/core";

interface IState {
  numberState: boolean;
  symbolState: boolean;
  textState: boolean;
}

const initIState = {
  numberState: false,
  symbolState: false,
  textState: false,
};

const Index: FC = () => {
  const [state, setState] = useState<IState>(initIState);

  const changeState = (key: Partial<IState>) => {
    console.log(key);
    setState({ ...state, ...key });
  };

  return (
    <>
      <Switch
        checked={state.numberState}
        onChange={(e) => changeState({ numberState: e.target.checked })}
      />
      <Switch
        checked={state.textState}
        onChange={(e) => changeState({ textState: e.target.checked })}
      />
      <Switch
        checked={state.symbolState}
        onChange={(e) => changeState({ symbolState: e.target.checked })}
      />
    </>
  );
};
export default Index;
