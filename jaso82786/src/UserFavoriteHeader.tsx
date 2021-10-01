import React, { FC, useState } from "react";

type Props = {
  onClick: (selectedAll: boolean) => void;
};
export const UserFavoriteHeader: FC<Props> = (props) => {
  const [selectedAll, setSelectedAll] = useState(false);

  const handleClick = () => {
    const v = !selectedAll;
    setSelectedAll(v);
    props.onClick(v);
  };

  return (
    <div>
      <input
        type="button"
        onClick={handleClick}
        value="UserFavoriteHeader button"
      />
    </div>
  );
};
