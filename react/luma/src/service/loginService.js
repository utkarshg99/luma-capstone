import axios from "axios";

export async function loginService(data){
    let bodyFormData = new FormData();
    bodyFormData.append('username', data.username);
    bodyFormData.append('password',data.password);
    return axios({
        method: "post",
        url: "http://localhost:8080/process_login",
        data: bodyFormData,
        headers: { "Content-Type": "multipart/form-data"
        },
    });
}
