import React, { Component } from "react";

class AddPost extends Component {
  state = {
    title: "",
    body: "",
  };

  handleChangeTitle = (e) => {
    this.setState({
      title: e.target.value,
    });
    console.log(this.state);
  };

  handleChangeBody = (e) => {
    this.setState({
      body: e.target.value,
    });
    console.log(this.state);
  };

  handleSubmit = (e) => {
    console.log("submit");
    e.preventDefault();
    // this.props.mapDispatchToProps(this.props.post.id);
    this.setState({
      title: "",
      body: " ",
    });
  };

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <label>title</label>
          <input
            type="text"
            id="title"
            onChange={this.handleChangeTitle}
            value={this.state.title}
          />
          <label>body</label>
          <input
            type="text"
            id="body"
            onChange={this.handleChangeBody}
            value={this.state.body}
          />
          <input type="submit" id="myadd" name="myadd" />
        </form>
      </div>
    );
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    addPost: (title, body) => {
      // dispatch(addPost(title, body));
    },
  };
};

// export default connect(mapDispatchToProps)(AddPost);

export default AddPost;
