import {Link, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import {dataFetchServicePost} from "../service/dataFetchService";

export function ItemsPurchasedDisplay(){
    let [data,setData]= useState();
    const navigate = useNavigate();
    useEffect(()=>{dataFetchServicePost('http://localhost:8080/items','E00001').then((res)=>{
        let cardData = res.data;
        let localData = []
        for(let item in cardData) {
            console.log(data);
            localData.push(<tr key={cardData[item].issue_id}>
                <th scope={'row'}>{cardData[item].issue_id}</th>
                <td>{cardData[item].description}</td>
                <td>{cardData[item].make}</td>
                <td>{cardData[item].category}</td>
                <td>{cardData[item].valuation}</td>
            </tr>);
        }
        setData(localData);
        console.log(res);
        console.log(data);
    },error=>{
        navigate('*',{state: {
                error: {
                    errstatus: error.status,
                    message: error.message
                }
            }})
    })},[]);
    return(
        <div className={'container'}>
            <h3 className={'centered m-5'}>Loan Cards Avaliled</h3>
            <table className={'table table-striped table-bordered table-hover'} >
                <thead className={'thead'}>
                <tr>
                    <th scope={'col'}>Issue_Id</th>
                    <th scope={'col'}>Item Description</th>
                    <th scope={'col'}>Item Make</th>
                    <th scope={'col'}>Item Category</th>
                    <th scope={'col'}>Item Valuation</th>
                </tr>
                </thead>
                <tbody>{data}</tbody>
            </table>
            <Link className={'btn btn-primary'} to={'/'}> Home </Link>
        </div>
    )
}
