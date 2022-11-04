import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Login from './components/Login';

function App() {


  const [user, setUser] = useState({email:"", password:""});

  return (
 
    <Login></Login>

  );
}

export default App;
