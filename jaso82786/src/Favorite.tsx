import React, { useState } from "react";
import useSWR from "swr";
import FavoriteBuild from "./FavoriteBuild";
import { NewData, NewDataState } from "./DataTypes";
import { UserFavoriteHeader } from "./UserFavoriteHeader";

export const Favorite = () => {
  const [state, setState] = useState<NewDataState[]>([]);

  const testUrl = "http://localhost:8080/";
  const fetcher = (url: string) =>
    fetch(url)
      .then((r) => r.json())
      .then((newdata: NewData[]) => {
        const newState = newdata.map((v) => {
          return {
            newdata: v,
            checked:
              state
                .filter((s) => s.newdata.name === v.name)
                .map((s) => s.checked)
                .shift() || false,
          } as NewDataState;
        });
        setState(newState);
      });
  useSWR(testUrl, fetcher);

  const changeChecked = (d: NewData) => {
    const newState = [...state];
    const s = newState.filter((s) => s.newdata.name === d.name)[0];
    s.checked = !s.checked;
    setState(newState);
  };

  const handleClick = (selectedAll: boolean) => {
    const newState = [...state];
    newState.forEach((s) => {
      s.checked = selectedAll;
    });
    setState(newState);
  };

  return (
    <>
      <FavoriteBuild changeChecked={changeChecked} state={state} />
      <UserFavoriteHeader onClick={handleClick} />
    </>
  );
};
