import React, { Component } from "react";

class Add extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
    };
  }
  onInput = (e) => {
    this.setState({
      name: e.target.value,
    });
  };
  addTodo = () => {
    const name = this.state.name;
    this.props.onAddTodo(name);
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
