import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Header from './components/header/Header';
import CardList from './components/Cards/CardsList.jsx'; 



function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <Header />
      <h1>Seja bem vindo a nossa AP2</h1>
      <CardList />
    </div>
  );
}

export default App;




