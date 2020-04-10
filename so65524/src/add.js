import React, { Component } from "react";

class Add extends Component {
  onInput = (e) => {
    this.setState({
      name: e.target.value,
    });
  };
  addTodo = () => {
    const { todos, name } = this.state;
    this.setState({
      todos: [...todos, name],
    });
  };

  render() {
    return (
      <div>
        <input type="text" onInput={this.onInput} />
        <button onClick={this.addTodo}>登録</button>
      </div>
    );
  }
}

export default Add;
