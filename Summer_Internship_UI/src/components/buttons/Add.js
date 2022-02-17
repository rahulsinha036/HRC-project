import React from "react";
import {useState} from 'react';
import Modal from '@material-ui/core/Modal';
import Dialog from '@material-ui/core/Dialog';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import Backdrop from '@material-ui/core/Backdrop';
import Fade from '@material-ui/core/Fade';
import { Paper } from '@material-ui/core';
import CloseIcon from '@material-ui/icons/Close';
import axios from "axios";
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Slide from '@material-ui/core/Slide';
import './modal.css'

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
  });

  function sendData(data){

    
    console.log(data)
    axios.get(`http://localhost:8080/1806126/add?name_customer=${data.customer_name}&cust_number=${data.customer_number}&orderId=${data.orderId}&total_open_amount=${data.total_open_amount}&due_date=${data.due_date}&notes=${data.notes})`)
       

  }

function Add(){

    const [show, setShow] = useState(false);
    const [open, setOpen] = useState(false);
    const data = {
        customer_name:"0",
        customer_number:"0",
        orderId:"0",
        total_open_amount:"0",
        due_date:"0",
        notes: ""
    }



return(
    <div>
            <button type="button" className = "normal-button" style={{top:"18vh" , left : "58vw"}}
                    onClick={()=>setShow(true)} ><b>{`\u002b`}</b>  Add</button>

            <Modal 
            open={show} 
            onClose={()=>setShow(false)} 
            style=
            {{display:"flex" , alignItems:"center" , justifyContent:"center"}}>

            <Fade in={show}>

                <Paper 
                className="modal-paper"
                style={{height:"53vh",width:"53vw" , outline:"none"}}>
                
                <div 
                className = "header"> 
                    <CloseIcon style={{position:"fixed" , left:"73vw" , cursor:"pointer"}} onClick={()=>setShow(false)} />  Add Invoice </div>

                    <div 
                    className = "Edit-text"
                    style={{position:"absolute" , top:"33vh" , left:"23vw"}}>
                       Customer Name <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>*</mark>  </div>

                    <input 
                    type="text" 
                    className = "search-bar" 
                    onChange={(event)=>data.customer_name=event.target.value}
                    style={{top:"35vh" , left : "34vw" , width:"13vw"}}/>

                    <div 
                    className = "Edit-text"
                    style={{position:"absolute" , top:"40.5vh" , left:"23vw"}}>
                       Customer No. <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>*</mark>  </div>
                    
                    <input 
                    type="text" 
                    className = "search-bar" 
                    onChange={(event)=>data.customer_number=event.target.value}
                    style={{top:"42.5vh" , left : "34vw" , width:"13vw"}}/>

                    <div 
                    className = "Edit-text"
                    style={{position:"absolute" , top:"47.5vh" , left:"23vw"}}>
                       Order ID <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>*</mark>  </div>

                    <input 
                    type="text" 
                    className = "search-bar" 
                    onChange={(event)=>data.orderId=event.target.value}
                    style={{top:"50vh" , left : "34vw" , width:"13vw"}}/>

                    <div 
                    className = "Edit-text"
                    style={{position:"absolute" , top:"55vh" , left:"23vw"}}>
                       Total Order Amt. <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>*</mark>  </div>

                    <input 
                    type="text" 
                    className = "search-bar" 
                    onChange={(event)=>data.total_open_amount=event.target.value}
                    style={{top:"57.5vh" , left : "34vw" , width:"13vw"}}/>

                    <div 
                    className = "Edit-text"
                    style={{position:"absolute" , top:"33vh" , left:"50vw"}}>
                        Due Date <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>*</mark>  </div>

                    <input 
                    type="text" 
                    className = "search-bar" 
                    onChange={(event)=>data.due_in_date=event.target.value}
                    style={{top:"35vh" , left : "60vw" , width:"13vw"}}/>

                    <div 
                    className = "Edit-text" 
                    style={{position:"absolute" , top:"41vh" , left:"50vw"}}> Notes</div>

                    <textarea 
                    className = "search-bar" 
                    onChange={(event)=>data.notes=event.target.value}
                    style={{top:"43vh" , left : "60vw" , width:"13vw" , height:"17vh"}}/>


                    <div className = "header-end" style={{paddingTop:"34vh"}}>

                <button type="button" className = "predict-button"  
                style={{top:"69vh" , left : "70vw" , paddingLeft:"1.1vw" , paddingRight:"1.1vw"}}
                    onClick={()=>{  
                        if(data.customer_name!=="0" && data.customer_number!=="0" && data.orderId!=="0"&&data.total_open_amount!=="0"&&data.due_date!=="0"){
                            sendData(data)
                            setShow(false)
                        }
                        else{
                            setOpen(true);
                        }}}> Add </button>

                <button type="button" className = "normal-button"  
                style={{top:"69vh" , left : "25vw" , paddingLeft:"1.1vw" , paddingRight:"1.1vw" , color:"#14aff0", backgroundColor:"inherit" , border:"none"}}
                onClick={()=>setShow(false)}>   Cancel </button>

                <Dialog
                    open={open}
                    TransitionComponent={Transition}
                    onClose={()=>{setOpen(false) 
                                setShow(false)}}
                    style={{position:"fixed" , top:"80vh", left:"-65vw" }}
                    PaperProps={{
                        style: {
                          backgroundColor:"#2a3f4d",
                          width:"30vw",
                          height:"8vh"
                        }}} >
                        <DialogContent>
                                <DialogContentText style={{color:"white" , paddingLeft:"2.5vw" }}>
                                    <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}><ErrorOutlineIcon style={{position:"fixed" , top:"88.5vh" , left:"4.5vw"}}/> </mark>Mandatory Fields cant be Empty
                                </DialogContentText>
                        </DialogContent>
                </Dialog>

                <button type="button" className = "normal-button"  style={{top:"69vh" , left : "64vw"}} onClick={()=>console.log("change me")}>Clear</button>
                </div>
                </Paper>
                </Fade>
            </Modal>
            </div>
        )
    
}

export default Add