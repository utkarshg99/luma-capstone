import React from 'react'

function Login() {
  return (
    <form>
    <div >
      <h1>LUMA</h1>
    </div>

    <div>
      <label>User Id</label>
      <input type="text" placeholder="1234"/ >
    </div>
    <div>
    <label>Password</label>
      <input type="password" placeholder='*******'/>
    </div>
    <button >Login</button>
</form>
  )
}

export default Login