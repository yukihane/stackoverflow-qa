import React, { useState, useEffect } from "react";

function App() {
  const [users, setUsers] = useState(null);

  useEffect(() => {
    fetch(`https://randomuser.me/api/?results=5&nat=us&inc=gender,name,email`)
      .then((res) => res.json())
      .then((json) => setUsers(json));
  }, []);

  return (
    <table border="1">
      <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Email</th>
      </tr>
      {users.results.map((result) => {
        return (
          <tr>
            <td>{result.name.first}</td>
            <td>{result.gender}</td>
            <td>{result.email}</td>
          </tr>
        );
      })}
    </table>
  );
}

export default App;
