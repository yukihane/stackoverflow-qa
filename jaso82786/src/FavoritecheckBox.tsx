import React, { FC } from "react";
import { MyData, MyDataState } from "./DataTypes";

type Props = {
  changeChecked: (data: MyData) => void;
  state: MyDataState[];
};

export const FavoritecheckBox: FC<Props> = (props) => {
  const inputs = props.state.map((value) => (
    <label key={value.data.name}>
      <input
        type="checkbox"
        onChange={() => props.changeChecked(value.data)}
        checked={value.checked}
      />
      {value.data.name}
    </label>
  ));

  return <div>{inputs}</div>;
};
