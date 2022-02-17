import React from 'react'

class Predict extends React.Component{

    constructor(){
        super()

    }
    render(props){
        return(
            <button type="button" className = {this.props.clicked?"predict-button":"gray-predict-button"}  style={{top:"18vh" , left : "3vw"}}>Predict</button>
        )
    }
}

export default Predict