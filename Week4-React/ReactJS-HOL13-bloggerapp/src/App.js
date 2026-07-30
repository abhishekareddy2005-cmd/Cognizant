import React, { Component } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selected: 'books'
    };
  }

  render() {
    let component;
    if (this.state.selected === 'books') {
      component = <BookDetails />;
    } else if (this.state.selected === 'blogs') {
      component = <BlogDetails />;
    } else {
      component = <CourseDetails />;
    }

    return (
      <div>
        <h1>Blogger App</h1>
        <button onClick={() => this.setState({ selected: 'books' })}>Books</button>
        <button onClick={() => this.setState({ selected: 'blogs' })}>Blogs</button>
        <button onClick={() => this.setState({ selected: 'courses' })}>Courses</button>

        {component}
      </div>
    );
  }
}

export default App;
