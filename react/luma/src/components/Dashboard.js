import {Link} from "react-router-dom";

export function Dashboard(){
    return (
      <div className={'container-fluid '}>
          <div className={'d-flex justify-content-between'}>
              <h2>Dashboard</h2>
              <div className={'me-1'}>
                  <Link className={'btn btn-outline-dark btn-round me-1'} to={'/login'}>Login</Link>
                  <Link className={'btn btn-outline-dark btn-round'} to={'/login'}>Sign in</Link>
              </div>
          </div>
          <div className={ 'd-flex pt-3 mt-4' }>
              <div className="card me-2" style={{width: 20+"%"}} >
                  <div className="card-body">
                      <h5 className="card-title">View Loans</h5>
                      <p className="card-text"></p>
                      <Link href="#" className="btn btn-primary" to={'/loans'}>Click here</Link>
                  </div>
              </div>
              <div className="card me-2" style={{width: 20+"%"}} >
                  <div className="card-body">
                      <h5 className="card-title">Apply for Loans</h5>
                      <p className="card-text"></p>
                      <Link href="#" className="btn btn-primary" to={'/apply'}>Click here</Link>
                  </div>
              </div>
              <div className="card me-2" style={{width: 20+"%"}} >
                  <div className="card-body">
                      <h5 className="card-title">View Items Purchased</h5>
                      <p className="card-text"></p>
                      <Link href="#" className="btn btn-primary" to={'/items'}>Click here</Link>
                  </div>
              </div>
          </div>
      </div>
    );
}
