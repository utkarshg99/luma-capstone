import axios from "axios";
import {getBasicAuthToken} from "./loginService";

export function addLoanService(url,eid,iid){
    return axios.post(url,{eid: eid,iid: iid},{
        headers: { 'Access-Control-Allow-Origin':'*'
            ,"Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With",
            "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
            "Authorization": getBasicAuthToken()
        }});
}
