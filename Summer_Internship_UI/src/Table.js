import React, { useEffect, useState } from "react";
import axios from "axios";
import "./index.css";
import InfiniteScroll from "react-infinite-scroll-component";
import Divtable from "./components/Divtable"
import Top from './components/Top'
import Loading from "./components/Loading"
import Buttons from "./components/Buttons"
import "./components/button.css"


function Table () {

    const [data, setData] = useState([]);         // Setting table data from recived data from server
    let [pageCount, setCount] = useState(0);      // Fetching data from local host
    const[check , setCheck] = useState([]);       // for the checkbox that are ticked, unticked
    const[dataind , setdataind] = useState([]);   // For sending selected data to Buttons component
    const[filter , setFilter]=useState(false);    // Conditional statement passed to Buttons to see if boxes are checked or not

    const getData = async () => {

        const fetchedData = (
         await axios.get(`http://localhost:8080/1806126/dummy?num=${pageCount}`)).data;
         console.log(fetchedData[100])
            setData(oldData => oldData.concat(fetchedData));
        };

   useEffect(()=>{
        getData();
        setCount(pageCount + 1000);
      },[]); 

    function fetchMoreData() {
      setCount(pageCount + 1000);
      getData();
    }



  return (
<div>
  
  <Buttons clicked={filter} data = {dataind} />    {/* Passing Props to Button */}

<div id = "scrollableDiv"
style = {{
  margin: "14vh 1vw 2vh 1.5vw", 
  height : "65vh",
  width:"95vw",
  overflow:'auto',
  display:'center',
  flexDirection:'auto',

}}>
<InfiniteScroll
        dataLength={data.length} //This is important field to render the next data
        next={fetchMoreData}
        hasMore={true}
        loader={ <Loading />}
        scrollableTarget = "scrollableDiv"
        >
      <table> 
            <Top/> 
    <tbody>

        {data.map((item,index) =>
           <tr key={index} style={check.includes(index)?{backgroundColor:"#2a5368"}:{}}>
            <td style={{width:"1.8vw"}}><input type="checkbox" 
            onClick={(event)=> {
              if(event.target.checked) 
              {setCheck(oldData => oldData.concat(index));
                setFilter(true)
                setdataind(oldData => oldData.concat(data[index]))
               
              } 
              else{setCheck(check.filter(item => item !== index))
                setFilter(check.length !== 1)
                setdataind(oldData => oldData.filter(item=>item!==data[index]))
             }
              }} 
           />
            </td>
            <td style={{width:"13vw"}} >{item.name_customer}</td>
            <td style={{width:"8vw"}}>{item.cust_number}</td>
            <td style={{width:"9vw"}}>{item.orderId}</td>
            <td style={{width:"11vw"}} >{item.total_open_amount}</td>
            <td style={{width:"12vw"}}>{item.due_date}</td>
            <td style={{width:"12vw"}}>{item.predicted_payment_date?item.predicted_payment_date:"-"}</td>
            <td style={{width:"12vw"}}>{item.predicted_aging_bucket?item.predicted_aging_bucket:"-"}</td>
            <td>{item.notes?item.notes:"Lorem Ipsum dolor sit amet"}</td>
          </tr>
          )   }
        
     </tbody>
       </table>
       </InfiniteScroll>
       </div>
       </div>
  );
}


export default Table