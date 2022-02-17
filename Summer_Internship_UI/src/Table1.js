import React from "react";
import axios from "axios";
import "./index.css";
import { CircularProgress } from "@material-ui/core";
import InfiniteScroll from "react-infinite-scroll-component";

function App() {
  let [responseData, setResponseData] = React.useState([]);
  let [isNext, isNextFunc] = React.useState(false);
  let [pageCount, setCount] = React.useState(1);
  const fetchData = () => {
    axios
      .get(`https://picsum.photos/v2/list?page=${pageCount}&limit=0`)
      .then((response) => {
        setResponseData([...responseData, ...response.data]);
        isNextFunc(true);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  function fetchMoreData() {
    setCount(pageCount + 1);
    fetchData();
  }
  return (
    <div className="App">
      <header className="App-header">
        <h1>Click To get Data from the API</h1>
      </header>
      <button type="button" onClick={fetchData}>
        Click for Data
      </button>
      <InfiniteScroll
        dataLength={responseData.length}
        next={fetchMoreData}
        hasMore={isNext}
        loader={
          <div
            style={{ height: "80%", paddingLeft: "35%", overflow: "hidden" }}
          >
            <CircularProgress />
          </div>
        }
      >
        <div>
          {responseData.map((data, index) => (
            <div
              key={index.toString()}
              style={{ height: "300px", width: "40%" }}
            >
              <li>{index}</li>
              {console.log(data.download_url)}
              <img
                src={data.download_url}
                alt={"No img"}
                width="300px"
                height="200px"
              />
            </div>
          ))}
        </div>
      </InfiniteScroll>
    </div>
  );
}
export default App;
