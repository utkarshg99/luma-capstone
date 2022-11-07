import './App.css';
import Login from './components/Login';
import {CardDisplay} from "./components/cardDisplay";
import {LMApplication} from "./components/LoanManagementApplication";
import {Dashboard} from "./components/Dashboard";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'


function App() {


  // const [user, setUser] = useState({email:"", password:""});
    const loanCardData = {title: 'Loans Cards Active',
        headers: ['Loan id','Loan Type','Duration','Card Issue Date'],
        entries: [{cardId: 'C10001', type: 'Furnature', duration: 5,issueDate: '2022-01-01'}]
    };
    const itemPurchaseData = {title: 'Items Purchased',
        headers: ['Issue id','Description','Item Make','Item Category','Item Valuation'],
        entries: [{issueId: 'C10001',description: 'tea table', make: 'Furnature', category: 'Furniture',valuation: '2022-01-01'}]
    };

    return (
        <Router>
          <Routes>
            <Route index path={'/'} element={<Dashboard />} />
            <Route path={'/login'} element={<Login />} />
            <Route path={'/apply'} element={<LMApplication />} />
            <Route path={'/loans'} element={<CardDisplay cardData={loanCardData} />} />
            <Route path={'/items'} element={<CardDisplay cardData={itemPurchaseData} />} />
          </Routes>
        </Router>

  );
}

export default App;
