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
import Slide from '@material-ui/core/Slide';
import './modal.css'


const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
  });

function Edit(props){

    const [show, setShow] = useState(false);
    const [open, setOpen] = useState(false);

        return(
            <div>
            <button type="button" className = {props.clicked?"normal-button":"gray-normal-button"} style={{top:"18vh" , left : "64vw"}}
            onClick={()=>props.clicked?setShow(true):setShow(false)}>{'\u270E'}  Edit</button>

            <Modal 
            open={show} 
            onClose={()=>setShow(false)} 
            style=
            {{display:"flex" , alignItems:"center" , justifyContent:"center"}}>

            <Fade in={show}>

                <Paper 
                className="modal-paper"
                style={{height:"55vh",width:"28vw" , outline:"none"}}>
                
                <div 
                className = "header"> 
                    <CloseIcon style={{position:"fixed" , left:"61vw" , cursor:"pointer"}} onClick={()=>setShow(false)} />  Edit Invoice </div>

                <div 
                    className = "Edit-text"
                    style={{position:"absolute" , top:"33vh"}}> Invoice Amount  </div>

                <input 
                    type="text" 
                    className = "search-bar" 
                    style={{top:"35vh" , left : "46vw" , width:"15vw"}}/>

                <div 
                    className = "Edit-text" 
                    style={{position:"absolute" , top:"41vh"}}> Notes</div>

                <textarea 
                    className = "search-bar" 
                    style={{top:"43vh" , left : "46vw" , width:"15vw" , height:"18vh"}}/>


                <div className = "header-end" style={{paddingTop:"34vh"}}>

                <button type="button" className = "predict-button"  
                style={{top:"70vh" , left : "58vw" , paddingLeft:"1.1vw" , paddingRight:"1.1vw"}}>   Save </button>

                <button type="button" className = "normal-button"  
                style={{top:"70vh" , left : "38vw" , paddingLeft:"1.1vw" , paddingRight:"1.1vw" , color:"#14aff0", backgroundColor:"inherit" , border:"none"}}
                onClick={()=>setShow(false)}>   Cancel </button>

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

                <button type="button" className = "normal-button"  style={{top:"70vh" , left : "52vw"}} onClick={()=>console.log("change me")}>Reset</button>
                </div>
                </Paper>
                </Fade>
            </Modal>
            </div>
        )
    }


export default Edit