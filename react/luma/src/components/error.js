import {Link} from "react-router-dom";

export function Error(props){
    return (
        <div className={'d-grid justify-content-center'}>
            <h1 className={ 'centered'}>{props.error.errstatus} {props.error.message}</h1>
            <Link to={'/'} className={'btn btn-primary'}>Go to home</Link>
        </div>
    )
}
