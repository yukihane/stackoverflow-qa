import React, { Component } from "react";
import Add from "./add";
import Todo from "./todo";

export default class Home extends Component {
  render() {
    return (
      <div>
        <Todo />
        <Add />
      </div>
    );
  }
}
