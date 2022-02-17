import React from 'react';
import {Button } from '@material-ui/core';
import "./button.css"
import Predict from './buttons/Predict'
import View from './buttons/View'
import Add from './buttons/Add'
import Edit from './buttons/Edit'
import Delete from './buttons/Delete'


function Buttons(props){
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => {
        setOpen(true);
      };
    
    const handleClose = () => {
        setOpen(false);
      };

    return(
<div>
   <Predict clicked={props.clicked} />
   <View clicked={props.clicked} />
    <Add />
   <Edit clicked={props.clicked} data={props.data}/>
   <Delete clicked={props.clicked} data = {props.data} />
    <input type="text" placeholder="Search by Order ID " className = "search-bar" style={{top:"18vh" , left : "78vw"}}/>
</div>
    )
}

export default Buttons