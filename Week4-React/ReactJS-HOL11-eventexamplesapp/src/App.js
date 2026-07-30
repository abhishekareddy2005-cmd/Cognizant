import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  increment = () => {
    this.setState({ counter: this.state.counter + 1 });
    this.sayHello();
  }

  decrement = () => {
    this.setState({ counter: this.state.counter - 1 });
  }

  sayHello = () => {
    console.log('Hello from increment!');
  }

  sayWelcome = (msg) => {
    alert(msg);
  }

  onPress = (e) => {
    alert('I was clicked');
  }

  render() {
    return (
      <div>
        <h1>Event Examples App</h1>

        <h3>Counter: {this.state.counter}</h3>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />
        <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>

        <br /><br />
        <button onClick={this.onPress}>OnPress Event</button>

        <br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
