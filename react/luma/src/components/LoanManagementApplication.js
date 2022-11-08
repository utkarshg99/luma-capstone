import {useForm} from "react-hook-form";
import {useEffect, useState} from "react";
import {dataFetchServiceGet} from "../service/dataFetchService";
import {addLoanService} from "../service/dataModifyService";
import {useNavigate} from "react-router-dom";
import {Header} from "./header";

export function LMApplication(){
    let [categoryData,setCategoryData] = useState([]);
    let [makeData,setMakeData] = useState([]);
    let [itemsData,setItemsData] = useState([]);
    let [final, setFinal] = useState('');
    // let [updateCheck, setUpdateCheck] = useState(false);
    const { register,handleSubmit, watch, setValue,getValues,resetField,formState: { errors, isValid } } = useForm({criteriaMode: 'all'});

    const navigate = useNavigate();
    const onSubmit = async (data)=> {
        let loanPromise = await addLoanService('http://localhost:8080/card_issue',getValues('employeeid'), final).catch(navigate('*'));
        navigate('/items')
    }

    const onError = ()=>{
        navigate('*');
    }
    const watchmakeandcategory = watch(['itemmake','itemcategory']);

    let disableExpression = !isValid || !watchmakeandcategory[0] || watchmakeandcategory[0]==='' || !watchmakeandcategory[1] || watchmakeandcategory[1]==='' //|| !updateCheck;
    useEffect(()=>{dataFetchServiceGet('http://localhost:8080/all/item').then((res)=>{
        console.log(res.data);
        setValue('employeeid',sessionStorage.getItem('username'));
        let data = res.data.filter(val => val.status==='T');
        let localCatData = []
        let keys = []
        for(let item in data){
            if(!keys.includes(data[item].category)){
                localCatData.push(<option key={item} value={data[item].category.toLowerCase()}>{data[item].category}</option>);
                keys.push(data[item].category);
            }
        }
        setCategoryData(localCatData);
        setItemsData(data);
    })},[]);

    useEffect(()=>{
        resetField('itemmake');
        // setUpdateCheck(false);
        let presentCategory = watch('itemcategory');
        let data = itemsData.filter(val => presentCategory === val.category.toLowerCase());
        let localMakeData = []
        for(let item in data) {
            localMakeData.push(<option key={data[item].make}>{data[item].make}</option>);
        }
        setMakeData(localMakeData);
    },[watch('itemcategory')]);

    useEffect(()=>{
        resetField('itemvalue');
        resetField('itemdescription')
        let choice = itemsData.filter(val => val.category.toLowerCase() === getValues('itemcategory') && val.make === getValues("itemmake"));
        setFinal(choice[0]?.id);
        setValue('itemvalue',choice[0]?.valuation);
        setValue('itemdescription',choice[0]?.description);
    },watch(['itemmake']));

    // useEffect(()=>{
    //     setUpdateCheck(true);
    //     console.log(final,updateCheck);
    // },[final]);

    return (
        <div>
            <Header />
            <div className={'header'}>
                <h3 className={'centered mt-5'}>Loan Management Application</h3>
            </div>
            <div className={'container d-flex justify-content-center'}>
              <form className={'form w-50 mt-3'} onSubmit={handleSubmit(onSubmit,onError)}>
                  <div className={'row'}>
                      <div className={'form-group col-6'}>
                          <label htmlFor={'employeeid'}>Employee id </label>
                          <input className={'form-control'} placeholder={'Ex: E12345'} type={'text'} id={'employeeid'} readOnly={true}
                              {...register('employeeid',{required:"please enter a valid employeeid", minLength:6, maxLength:6})} />
                          {errors.employeeid && <small color={'red'}>{errors.employeeid.message}</small>}
                      </div>
                      <div className={'form-group col-6'}>
                          <label htmlFor={'itemcategory'}>Item Category</label>
                          <select className={'form-control'} id={'itemcategory'} defaultValue={'/'}
                                  {...register('itemcategory', {required: 'Select one of the option'})}>
                              <option value={''} >Select</option>
                              {categoryData}
                          </select>
                          {errors.itemcategory}
                      </div>
                  </div>
                  <div>
                      <div className={'row'}>
                          <div className={'form-row col-6'}>
                              <label htmlFor={'itemmake'}>Item Make</label>
                              <select className={'form-control'} defaultValue={''}
                                      {...register('itemmake')}>
                                  <option value={''}>Select</option>
                                  {makeData}
                              </select>
                          </div>
                          <div className={'form-row col-6'}>
                              <label htmlFor={'itemvalue'}>Item Value</label>
                              <input className={'form-control'} placeholder={'Ex: 10000'} type={'number'} id={'itemvalue'} readOnly={true} {...register('itemvalue',{required:true})}/>
                          </div>
                      </div>
                      <div className={'row'}>
                          <div className={'form-row col-12'}>
                              <label htmlFor={'itemdescription'}>Item Description</label>
                              <input className={'form-control'} placeholder={'Ex: Tea Table'} type={'text'}
                                     id={'itemdescription'} {...register('itemdescription',{required:true})} readOnly={true} />
                          </div>
                      </div>
                      <button className={'mt-2 btn btn-primary'} disabled={ disableExpression} type={'submit'}>Apply Loan</button>
                  </div>
              </form>
            </div>
        </div>
    );
}
