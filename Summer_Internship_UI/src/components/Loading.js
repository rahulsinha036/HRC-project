import React from 'react';
import { CircularProgress } from "@material-ui/core";

export default function Loading(){

    return(
    <div>
        <div
          style={{overflow: "auto" , postion:"relative" , paddingTop:"20vh", paddingLeft:"42vw" , marginBottom:"-2.3vh"}}
        >
          <CircularProgress />
          </div>
          <p style={{paddingLeft: "41.8vw", fontFamily:"Calibri" , color:"#95a0a8" }}>Loading</p>
     </div>)
}