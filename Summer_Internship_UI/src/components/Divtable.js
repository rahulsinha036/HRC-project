import { keys } from '@material-ui/core/styles/createBreakpoints';
import React from 'react';
import "./table.css"


class Divtable extends React.Component{
    render(){

    const headerElement = ["Customer Name ", "Customer #", "Invoice #", "Invoice Amount", "Due Date" , "Predicted Payment Date" , "Predicted Aging Bucket" , "Notes"];
    return (
        <div class="table">
       <div class="table-row" key={headerElement}>
       <div class="table-cell-1"><input type="checkbox" /></div>
        <div class="table-cell-2" >Customer Name</div>
        <div class="table-cell-3" >Customer #</div>
        <div class="table-cell-4" >Order ID #</div>
        <div class="table-cell-5">Total Order Amount</div>
        <div class="table-cell-6" >Due Date</div>
        <div class="table-cell-7" >Predicted Payment Date</div>
        <div class="table-cell-8">Predicted Aging Bucket</div>
        <div class="table-cell-9">Notes</div>
        </div>
      </div>
    );

    }
}
export default Divtable