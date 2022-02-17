import React from 'react'
import Modal from '@material-ui/core/Modal';
import Backdrop from '@material-ui/core/Backdrop';
import Fade from '@material-ui/core/Fade';

class View extends React.Component{

    constructor(){
        super()

    }
    render(props){
        return(
            <button type="button" className = {this.props.clicked?"normal-button":"gray-normal-button"} style={{top:"18vh" , left : "9vw"}}>View Correspondence</button>
        )
    }
}

export default View