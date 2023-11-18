import { Link } from "react-router-dom";
import React from "react";

export function Welcome() {
  return (
    <div className={"Welcome"}>
      <h1>Welcome </h1>
      <div>
        Manage Your todos. <Link to={"/todos"}>Go here</Link>
      </div>
    </div>
  );
}