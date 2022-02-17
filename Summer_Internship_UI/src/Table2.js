import React, { useEffect, useState } from "react";
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import axios from "axios";
import "./index.css";
import { CircularProgress } from "@material-ui/core";
import InfiniteScroll from "react-infinite-scroll-component";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});



function Table2() {

  const [data, setData] = useState([]);

    const getData = async () => {

        const fetchedData = (
         await axios.get("http://localhost:8080/1806126/dummy/secondScreen/")).data;
          setTimeout(console.log(fetchedData),1000) 
            setData(oldData => oldData.concat(fetchedData));
        };

    useEffect(()=>{
        getData();
    },[]);

  const classes = useStyles();

  return (
    
    <TableContainer component={Paper}>
      <InfiniteScroll
           dataLength={data.length} //This is important field to render the next data
           next={getData}
           hasMore={data.hasMore}
           loader={<CircularProgress />}>
      <Table className={classes.table} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>First Col</TableCell>
            <TableCell align="right">Second Col</TableCell>
            <TableCell align="right">Third Col</TableCell>
            <TableCell align="right">fourth col</TableCell>
            <TableCell align="right">fifth col</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((item,index) => (
            <TableRow key={index}>
              <TableCell component="th" scope="row">{item.name_customer}</TableCell>
              <TableCell align="right">{item.cust_number}</TableCell>
              <TableCell align="right">{item.orderId}</TableCell>
              <TableCell align="right">{item.total_open_amount}</TableCell>
              <TableCell align="right">{item.due_date}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      </InfiniteScroll>
    </TableContainer>
  );
}

export default Table2