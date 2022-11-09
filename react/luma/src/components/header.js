import axios from "axios";
import {Link} from "react-router-dom";
import {useNavigate} from 'react-router-dom';

export const Header=()=>{

    const navigate = useNavigate();
    async function logoutRequest () {
        await axios.get("/logout");
        navigate('/login');
    }

    return (
        <div className={'d-flex justify-content-between '}>
            <Link className={'btn '} to={'/'}><h3>Dashboard</h3></Link>
            {sessionStorage.getItem('username') && <Link className={'btn btn-outline-dark mt-2'} onClick={logoutRequest}>Logout</Link>}
        </div>
    )
}
