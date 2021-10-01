import React, { FC } from "react";
import { NewData, NewDataState } from "./DataTypes";

type Props = {
  changeChecked: (newdata: NewData) => void;
  newDataState: NewDataState[];
};

export const FavoritecheckBox: FC<Props> = (props) => {
  const inputs = props.newDataState.map((value) => (
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
