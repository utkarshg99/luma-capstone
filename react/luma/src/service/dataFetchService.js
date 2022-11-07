import axios from 'axios';

export function dataFetchServicePost(url,empId){
    return axios.post(url,{eid: empId},
        {auth: {username: 'E00001',password: 'LUMA_password'},
    headers: { 'Access-Control-Allow-Origin':'*'
        ,"Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With",
        "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS"
    }});
}
export function dataFetchServiceGet(url){
    return axios.get(url,
        {headers: {'ACCESS-CONTROL-ALLOW-ORIGIN':'*'}});
}
