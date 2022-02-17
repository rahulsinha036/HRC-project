import React, { useEffect, useState } from "react";

import Table from './Table'
import "./index.css";
import { Paper } from '@material-ui/core';

import { ReactComponent as Hrc } from './assets/logo.svg';
import { ReactComponent as Company } from './assets/companyLogo.svg';



function App(){
    
  return (
  
    <div> 
    <div>
      <Company style={{position:"fixed" , top:"2vh" , transform:"scale(0.9)"}} />
      <Hrc style={{position:"fixed" , top:"1vh" , left:"42vw" , transform:"scale(0.8)"}}/>
      <p style={{fontSize:"calc(1vh + 0.8vw)" ,fontFamily:"sans-serif", color:"white", position:"fixed" , top:"8vh" , left:"1.5vw"}}> Invoice List</p>
      </div>
    <Paper 
       style = {{
       height : "83vh",
       overflow:'auto',
       position:"absolute",
       display:'flex',
       flexDirection:'auto',
       backgroundColor:"#2d4250",
       borderRadius:"10px",
  }}>
        <Table />

  </Paper>
    </div>

  );
}


export default App