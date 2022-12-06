import React, { useState } from "react";

import "react-datepicker/dist/react-datepicker.css";
import DatePicker, { registerLocale } from "react-datepicker";
// import ja from "date-fns/locale/ja"; // register it with the name you want

// registerLocale("ja", ja);

const App = () => {
  const [startDate, setStartDate] = useState(new Date());
  return (
    <DatePicker
      locale="ja-JP"
      selected={startDate}
      onChange={(date) => setStartDate(date)}
      dateFormat="MM/yyyy"
      showMonthYearPicker
    />
  );
};

export default App;
