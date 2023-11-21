import React, { useEffect, useState } from "react";
import { deleteTodo, getTodos } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export function ListTodo() {
  const today = new Date();
  const authContext = useAuth();
  const username = authContext.username;
  const navigate = useNavigate();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay(),
  );
  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);

  useEffect(() => {
    loadTodo();
  }, []);

  function loadTodo() {
    getTodos(username)
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function removeTodo(id) {
    console.log(`delete+${id}`);
    deleteTodo(username, id)
      .then(() => {
        setMessage(`Deleted ${id} success`);
        loadTodo();
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function updateTodo(id) {
    console.log(`update+${id}`);
    navigate(`/todos/${id}`);
  }

  function addNewTodo() {
    navigate(`/todos/-1`);
  }

  return (
    <div className={"container"}>
      <h1>Things You want to do</h1>
      {message && <div className={"alert alert-success"}>{message}</div>}
      <div>
        <table className={"table"}>
          <thead>
            <tr>
              <th>description</th>
              <th>Is Done?</th>
              <th>targetDate</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                {/*<td>{todo.targetDate.toDateString()}</td>*/}
                <td>{todo.targetDate.toString()}</td>
                <td>
                  <button
                    className={"btn btn-success"}
                    onClick={() => updateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
                <td>
                  <button
                    className={"btn btn-danger"}
                    onClick={() => removeTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
          <tfoot></tfoot>
        </table>
      </div>
      <div className={"btn btn-success m-5"} onClick={addNewTodo}>
        Add New Todo
      </div>
    </div>
  );
}