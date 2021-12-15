import logo from './logo.svg';
import './App.css';
import React from 'react';
import axios from 'axios';


// class Appp extends React.Component {
//   constructor(props) {
//     super(props);

//     this.state = {
//       list: [1, 2, 3],
//     };
//   }

//   onClearArray = () => {
//     this.setState({ list: [] });
//   };

//   render() {
//     return (
//       <div>
//         <ul>
//           {this.state.list.map(item => (
//             <li key={item}>{item}</li>
//           ))}
//         </ul>

//         <button type="button" onClick={this.onClearArray}>
//           Clear Array
//         </button>
//       </div>
//     );
//   }
// }

// function App() {
//   return (
//     <Appp />
//   );
// }
const productUrl = `https://b4zok3p9c1.execute-api.us-east-1.amazonaws.com/products`;

class NameForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: '', 
      price: '', 
      nameValue: '',
      pictureUrl: '',
      products: []
    };

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    axios.get(productUrl)
      .then(res => {
        const products = res.data.body.Items;
        this.setState({ products });
      })
  }

  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  handleSubmit(event) {
    const product = {
      id: this.state.id,
      price: this.state.price,
      nameValue: this.state.nameValue,
      pictureUrl: this.state.pictureUrl
    };

    axios.post(productUrl, { product }).catch(err => {
      console.log(err);
    });
    this.componentDidMount();
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Id:
          <input name="id" type="text" value={this.state.id} onChange={this.handleInputChange} />
          <br/>
          Price:
          <input name="price" type="text" value={this.state.price} onChange={this.handleInputChange} />
          <br/>
          Name value:
          <input name="nameValue" type="text" value={this.state.nameValue} onChange={this.handleInputChange} />
          <br/>
          Picture url:
          <input name="pictureUrl" type="text" value={this.state.pictureUrl} onChange={this.handleInputChange} />
          <br/>
        </label>
        <input type="submit" value="Отправить" />
        <br />
        <ul>
          { this.state.products.map(product => <li key={product.id}>{product.id} {product.price} {product.nameValue} {product.pictureUrl}</li>)}
        </ul>
      </form>
    );
  }
}

function App() {
  return (
    <NameForm />
  );
}

export default App;
