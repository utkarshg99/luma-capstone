import './App.css';
import Login from './components/Login';
import {LMApplication} from "./components/LoanManagementApplication";
import {Dashboard} from "./components/Dashboard";
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import {LoanCardDisplay} from "./components/loanCardDisplay";
import {ItemsPurchasedDisplay} from "./components/itemsPurchasedDisplay";
import {Error} from "./components/error";


function App() {
    return (
        <>
            <Router>
              <Routes>
                <Route path={'/'} element={<Dashboard />} />
                <Route index path={'/login'} element={<Login />} />
                <Route path={'/apply'} element={<LMApplication />} />
                <Route path={'/loans'} element={<LoanCardDisplay/>} />
                <Route path={'/items'} element={<ItemsPurchasedDisplay />} />
                <Route path={'*'} element= {<Error error={{errstatus: 404,message: 'Page not found'}}/>} />
              </Routes>
            </Router>
        </>
  );
}

export default App;
