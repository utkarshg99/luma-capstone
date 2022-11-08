import {Link} from "react-router-dom";

export const Header=()=>{
    return (
        <div className={'d-flex justify-content-between '}>
            <Link className={'btn '} to={'/'}><h3>Dashboard</h3></Link>
            {sessionStorage.getItem('username') && <Link className={'btn btn-outline-dark mt-2'} to={'/login'}>Logout</Link>}
        </div>
    )
}
