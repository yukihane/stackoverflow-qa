import React, { Component } from "react";

class Todo extends Component {
  render() {
    const todos = this.props.todos.slice();

    return (
      <div>
        <ul>
          {todos.map((todo, index) => (
            <li key={index}>{todo}</li>
          ))}
        </ul>
      </div>
    );
  }
}
export default Todo;
