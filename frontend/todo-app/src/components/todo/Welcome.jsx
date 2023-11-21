import { Link, useParams } from "react-router-dom";
import React, { useState } from "react";
import { getHelloWorldPathVariable } from "./api/HelloWorld";
import { useAuth } from "./security/AuthContext";

export function Welcome() {
  const { username } = useParams();

  const [message, setMessage] = useState(null);

  const authContext = useAuth();

  function helloWorldApi() {
    console.log("Welcome");

    getHelloWorldPathVariable(`${username}`, authContext.token)
      .then((response) => successfulResponse(response))
      .catch((error) => failedResponse(error))
      .finally(() => console.log("cleanup"));
  }

  function successfulResponse(response) {
    console.log(response);
    setMessage(response.data.message);
  }

  function failedResponse(error) {
    console.log(error);
  }

  return (
    <div className={"Welcome"}>
      <h1>Welcome {username}</h1>
      <div>
        Manage Your todos. <Link to={"/todos"}>Go here</Link>
      </div>
      <div>
        <button className={"btn btn-success"} onClick={helloWorldApi}>
          Call Hello World API
        </button>
      </div>
      <div className={"text-info"}>{message}</div>
    </div>
  );
}