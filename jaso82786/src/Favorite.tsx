import React, { useState } from "react";
import useSWR from "swr";
import FavoriteBuild from "./FavoriteBuild";
import { MyData, MyDataState } from "./DataTypes";
import { UserFavoriteHeader } from "./UserFavoriteHeader";

export const Favorite = () => {
  const [state, setState] = useState<MyDataState[]>([]);

  const testUrl = "http://localhost:8080/";
  const fetcher = (url: string) =>
    fetch(url)
      .then((r) => r.json())
      .then((newData: MyData[]) => {
        const newState = newData.map((v) => {
          return {
            data: v,
            checked: !!state
              .filter((s) => s.data.name === v.name)
              .map((s) => s.checked)
              .shift(),
          } as MyDataState;
        });
        setState(newState);
      })
      .catch(() => {
        setState([
          { data: { name: "foo" }, checked: false },
          { data: { name: "bar" }, checked: false },
          { data: { name: "baz" }, checked: false },
        ]);
      });
  useSWR(testUrl, fetcher);

  const changeChecked = (d: MyData) => {
    const newState = [...state];
    const s = newState.filter((s) => s.data.name === d.name)[0];
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
