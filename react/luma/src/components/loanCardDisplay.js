import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import {dataFetchServicePost} from "../service/dataFetchService";

export function LoanCardDisplay(){
    let [data,setData]= useState();
    const navigate = useNavigate();
    useEffect(()=>{dataFetchServicePost('http://localhost:8080/loans',sessionStorage.getItem('username')).then((res)=>{
        let cardData = res.data;
        console.log(cardData);
        let localData = []
        for(let item in cardData) {
           localData.push(<tr key={item}>
                <th scope={'row'}>{cardData[item].id}</th>
                <td>{cardData[item].type}</td>
                <td>{cardData[item].duration}</td>
                <td>{cardData[item].cards[0].cid}</td>
            </tr>);
        }
        setData(localData);
    },()=>{
        navigate('*');
    })},[]);
    return(
        <div className={'container'}>
            <h3 className={'centered m-5'}>Loan Cards Availed</h3>
            <table className={'table table-striped table-bordered table-hover'} >
                <thead className={'thead'}>
                <tr>
                    <th scope={'col'}>Loan Id</th>
                    <th scope={'col'}>Loan Type</th>
                    <th scope={'col'}>Duration</th>
                    <th scope={'col'}>Card Issue Date</th>
                </tr>
                </thead>
                <tbody>{data}</tbody>
            </table>
        </div>
    )
}
