import {Link} from "react-router-dom";

export function CardDisplay(props){
    const Rawheaders = props.cardData.headers;
    let headers = []
    let data = [];
    const entries = props.cardData.entries;
    for( let item in Rawheaders){
        headers.push(<th scope={'col'} key={item}>{Rawheaders[item]}</th>);
    }
    for(let item in entries){
        let dummy = []
        for (let entryKey in entries[item]) {
            dummy.push(<td key={entryKey}>{entries[item][entryKey]}</td>)
        }
        data.push(<tr key={item}>{dummy}</tr>);
    }
    return(
        <div className={'container'}>
            <h3 className={'centered m-5'}>{props.cardData.title}</h3>
            <table className={'table table-striped table-bordered table-hover'} >
                <thead className={'thead'}>
                    <tr>
                        {headers}
                    </tr>
                </thead>
                <tbody>
                {data}
                </tbody>
            </table>
            <Link className={'btn btn-primary'} to={'/'}> Home </Link>
        </div>
    )
}
