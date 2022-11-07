import axios from "axios";

export function addLoanService(url,eid,iid){
    return axios.post(url,{eid: eid,iid: iid});
}
