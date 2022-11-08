import React from 'react'
import { useForm } from "react-hook-form";
import {createBasicAuthToken, loginService} from "../service/loginService";
import {useNavigate} from 'react-router-dom';

function Login() {
    sessionStorage.clear();
    const {register, handleSubmit, getValues,formState: { errors }} = useForm();
    const navigate = useNavigate();
    const onSubmit = async (data)=>{
        let loginPromise = await loginService(data);
        console.log(loginPromise.status);
        if(loginPromise.status===200){
            sessionStorage.setItem('Authentication',createBasicAuthToken(getValues('username'),getValues('password')));
            sessionStorage.setItem('username',getValues('username'));
        }
        else{
            console.log('error');
        }
        navigate('/')
    }
    const validateEmpId = (value)=> value.toString().substring(0,1).toLowerCase() === 'e' && !isNaN(value.toString().substring(1));
  return (
      <div>
        <div className={'container centered mt-5'}>
          <h1>LUMA</h1>
        </div>
        <div className={'container d-flex justify-content-center w-25'} onSubmit={handleSubmit(onSubmit)}>
            <form className={'w-100'}>
                <div className={'form-group'}>
                    <label htmlFor={'userid'} className={'form-label'}>User Id</label>
                    <input id={'userid'} type={"text"} placeholder={"Ex:E12345"} className={'form-control'} {...register('username',{required: 'user name is required', minLength: 6, maxLength: 6, validate: value => validateEmpId(value)})} />
                    {errors.username && <small className={'text-danger'}>{errors.username.message}</small>}
                    {errors.username && (errors.username.type ===  'maxLength' || errors.username.type ===  'minLength') && <small className={'text-danger'}>Length of 6 is required</small>}
                    {errors.username && errors.username.type === 'validate' && <small className={'text-danger'}>Please Enter a valid employee id (Ex: E12345)</small> }
                </div>
                <div className={'form-group'}>
                    <label htmlFor={'password'} className={'form-label'}>Password</label>
                    <input type="password" placeholder='*******' className={'form-control'} {...register('password',{required: 'password is required'})} />
                    {errors.password && <small className={'text-danger'}>{errors.password.message}</small>}
                </div>
                <button className={'mt-3 btn btn-primary'} >Login</button>
            </form>
        </div>
      </div>
  );
}

export default Login
