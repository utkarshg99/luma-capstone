import { useForm } from "react-hook-form";

export function LMApplication(){
    const { register, handleSubmit, watch, formState: { errors, isValid } } = useForm({criteriaMode: 'all'});
    const onSubmit=(data)=> {
        console.log(data);
        console.log(errors);
    }
    const watchmakeandcategory = watch(['itemmake','itemcategory']);
    let disableExpression = !isValid || !watchmakeandcategory[0] || watchmakeandcategory[0]==='' || !watchmakeandcategory[1] || watchmakeandcategory[1]==='';

    return (
        <div>
            <div className={'header'}>
                <h3 className={'centered mt-5'}>Loan Management Application</h3>
            </div>
            <div className={'container d-flex justify-content-center'}>
              <form className={'form w-50 mt-3'} onSubmit={handleSubmit(onSubmit)}>
                  <div className={'row'}>
                      <div className={'form-group col-6'}>
                          <label htmlFor={'employeeid'}>Employee id </label>
                          <input className={'form-control'} placeholder={'Ex: E12345'} type={'text'} id={'employeeid'}
                              {...register('employeeid',{required:"please enter a valid employeeid", minLength:6, maxLength:6})} />
                          {errors.employeeid && <small color={'red'}>{errors.employeeid.message}</small>}
                      </div>
                      <div className={'form-group col-6'}>
                          <label htmlFor={'itemcategory'}>Item Category</label>
                          <select className={'form-control'} id={'itemcategory'} defaultValue={'/'}
                                  {...register('itemcategory', {required: 'Select one of the option'})}>
                              <option value={''} >Select</option>
                              <option value={'furniture'}>Furniture</option>
                              <option value={'crockery'}>Crockery</option>
                              <option value={'stationary'}>Stationary</option>
                          </select>
                          {errors.itemcategory}
                      </div>
                  </div>
                  <div>
                      <div className={'row'}>
                          <div className={'form-row col-6'}>
                              <label htmlFor={'itemdescription'}>Item Description</label>
                              <input className={'form-control'} placeholder={'Ex: Tea Table'} type={'text'}
                                     id={'itemdescription'} {...register('itemdescription',{required:true})}/>
                          </div>
                          <div className={'form-row col-6'}>
                              <label htmlFor={'itemvalue'}>Item Value</label>
                              <input className={'form-control'} placeholder={'Ex: 10000'} type={'number'} id={'itemvalue'} {...register('itemvalue',{required:true})}/>
                          </div>
                      </div>
                      <div className={'row'}>
                          <div className={'form-row col-12'}>
                              <label htmlFor={'itemmake'}>Item Make</label>
                              <select className={'form-control'} defaultValue={''}
                                      {...register('itemmake')}>
                                  <option value={''}>Select</option>
                                  <option value={'wood'}>Wood</option>
                                  <option value={'glass'}>Glass</option>
                                  <option value={'plastic'}>Plastic</option>
                              </select>
                          </div>
                      </div>
                      <button className={'mt-2 btn btn-primary'} disabled={ disableExpression} type={'submit'}>Apply Loan</button>
                  </div>
              </form>
            </div>
        </div>
    );
}
