import React, { FC } from "react";
import { FavoritecheckBox } from "./FavoritecheckBox";
import { NewDataState, NewData } from "./DataTypes";

type Prop = {
  changeChecked: (d: NewData) => void;
  state: NewDataState[];
};

const FavoriteBuild: FC<Prop> = (props) => {
  return (
    <FavoritecheckBox
      changeChecked={props.changeChecked}
      newDataState={props.state}
    />
  );
};

export default FavoriteBuild;
