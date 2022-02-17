import React from "react";
import {useState} from 'react';
import Modal from '@material-ui/core/Modal';
import Dialog from '@material-ui/core/Dialog';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';

import Fade from '@material-ui/core/Fade';
import { Paper } from '@material-ui/core';
import CloseIcon from '@material-ui/icons/Close';
import axios from "axios";
import Slide from '@material-ui/core/Slide';
import './modal.css'

function sendData(props){

    props.data.map((item)=> {

         axios.get(`http://localhost:8080/1806126/delete?orderId=${item.orderId}`)
        })

}

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
  });

function Delete(props){


    const [show, setShow] = useState(false);
    const [open, setOpen] = useState(false);

    let closeImg = {cursor:'pointer', float:'right', marginTop: '5px', width: '20px'};
        return(
        <div>
            <button type="button" className = {props.clicked?"normal-button":"gray-normal-button"} style={{top:"18vh" , left : "70.5vw"}}
            onClick={()=>props.clicked?setShow(true):setShow(false)}>
                <b>{'\u2014'}</b>  Delete
                </button>
            <Modal open={show} onClose={()=>setShow(false)} style={{display:"flex" , alignItems:"center" , justifyContent:"center"}}>
            <Fade in={show}>
                <Paper className="modal-paper"
                style={{height:"37vh",width:"31.5vw" , outline:"none"}}>
                
                <div className = "header"> <CloseIcon style={{position:"fixed" , left:"63vw" , cursor:"pointer"}} onClick={()=>setShow(false)} />
                 Delete record(s)?</div>

                <div className = "main-text">You'll lose your record(s) and it won't recover once<br/> deleted <br/><br/>
                 Are your sure you want to <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>delete them permanently</mark>
                </div>

                <div className = "header-end">

                <button type="button" className = "predict-button"  
                style={{top:"61.5vh" , left : "59vw" , paddingLeft:"1.1vw" , paddingRight:"1.1vw"}}
                onClick={()=>{sendData(props)  /* Put sendData(props here to actually delete the row) */
                            setOpen(true)  }}>   Delete </button>
               

                <Dialog
                    open={open}
                    TransitionComponent={Transition}
                    onClose={()=>{setOpen(false) 
                                setShow(false)}}
                    style={{position:"fixed" , top:"80vh", left:"-60vw" }}
                    PaperProps={{
                        style: {
                          backgroundColor:"#2a3f4d",
                        }}} >
                        <DialogContent>
                                <DialogContentText style={{color:"white"}}>
                                    Selected rows have been <mark style={{color:"rgb(226, 104, 104)" , background:"none"}}>Deleted</mark>, refresh the page to see the changes
                                </DialogContentText>
                        </DialogContent>
                </Dialog>

                <button type="button" className = "normal-button"  style={{top:"61.5vh" , left : "53vw"}} onClick={()=>setShow(false)}>Cancel</button>
                </div>
                </Paper>
                </Fade>
            </Modal>
          
          </div>
          )
    
}

export default Delete