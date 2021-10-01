import React, { FC } from "react";
import { FavoritecheckBox } from "./FavoritecheckBox";
import { MyDataState, MyData } from "./DataTypes";

type Prop = {
  changeChecked: (d: MyData) => void;
  state: MyDataState[];
};

export const FavoriteBuild: FC<Prop> = (props) => {
  return (
    <FavoritecheckBox changeChecked={props.changeChecked} state={props.state} />
  );
};
