import axios from "axios";

export async function loginService(data){
    return axios({
        method: "get",
        url: "http://localhost:8080/perform_login",
        headers: {
            'Access-Control-Allow-Origin':'*',
            "Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With",
            "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
            "Authorization": data },
    });
}
export const createBasicAuthToken =(username, password)=> {
    return 'Basic ' + btoa(username + ":" + password)
}
export const getBasicAuthToken =()=>{
    if(!sessionStorage.getItem('Authentication')){
        return 'Basic';
    }
    return sessionStorage.getItem('Authentication');
}
