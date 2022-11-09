import axios from 'axios';
import {getBasicAuthToken} from "./loginService";

export function dataFetchServicePost(url,empId){
    return axios.post(url,{eid: empId},
        {
    headers: { 'Access-Control-Allow-Origin':'*'
        ,"Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With",
        "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
        "Authorization": getBasicAuthToken()
    }});
}
export function dataFetchServiceGet(url){
    return axios.get(url,
        {
            headers: { 'Access-Control-Allow-Origin':'*'
                ,"Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With",
                "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
                "Authorization": getBasicAuthToken()
            }});
}
