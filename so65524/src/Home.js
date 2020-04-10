import React, { Component } from "react";
import Add from "./add";
import Todo from "./todo";

export default class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      todos: [],
    };
  }

  handleAddTodo = (name) => {
    const todos = this.state.todos.slice();
    todos.push(name);
    this.setState({ todos });
  };

  render() {
    return (
      <div>
        <Todo todos={this.state.todos} />
        <Add onAddTodo={this.handleAddTodo} />
      </div>
    );
  }
}
