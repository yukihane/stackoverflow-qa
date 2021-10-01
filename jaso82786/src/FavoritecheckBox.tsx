import React, { FC } from "react";
import { NewData, NewDataState } from "./DataTypes";

type Props = {
  changeChecked: (newdata: NewData) => void;
  newDataState: NewDataState[];
};

export const FavoritecheckBox: FC<Props> = (props) => {
  const inputs = props.newDataState.map((value) => (
    <input
      key={value.newdata.name}
      type="checkbox"
      onChange={() => props.changeChecked(value.newdata)}
      checked={value.checked}
    />
  ));

  return <>{inputs}</>;
};
