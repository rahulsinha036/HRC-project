import React from 'react';


class Top extends React.Component{
    render(){

   // const headerElement = ["Customer Name", "Customer #", "Order ID #", "Total Order Amount", "Due Date" , "Predicted Payment Date" , "Predicted Aging Bucket" , "Notes"];
    return (
      <thead>
        <tr >
          <th style={{width:"1.8vw"}} ><input type="checkbox" /></th>
          <th style={{width:"13vw"}}>Customer Name</th>
          <th style={{width:"8vw"}}>Customer #</th>
          <th style={{width:"9vw"}}>Order ID #</th>
          <th style={{width:"11vw"}}>Total Order Amount</th>
          <th style={{width:"12vw"}}>Due Date</th>
          <th style={{width:"12vw"}}>Predicted Payment Date</th>
          <th style={{width:"12vw"}}>Predicted Aging Bucket</th>
          <th style={{paddingRight:"7.2vw"}}>Notes</th>
        </tr>
      </thead>
    );

    }
}
export default Top