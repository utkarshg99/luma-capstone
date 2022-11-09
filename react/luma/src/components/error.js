import {Link} from "react-router-dom";

export function Error(props){
    let username = sessionStorage.getItem('username')
    return (
        <div className={'d-grid justify-content-center'}>
            <h1 className={ 'centered'}>{props.error.errstatus} {props.error.message}</h1>
            <Link to={!username ? 'login': '/'} className={'btn btn-primary'}>{!username ?'Login': 'Go to home'}</Link>
        </div>
    )
}
