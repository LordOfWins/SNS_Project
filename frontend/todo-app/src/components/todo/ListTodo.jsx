import React from "react";

export function ListTodo() {
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay(),
  );
  const todos = [
    { id: 1, description: "test", done: false, targetDate: targetDate },
    { id: 2, description: "test2", done: false, targetDate: targetDate },
    { id: 3, description: "test3", done: false, targetDate: targetDate },
  ];
  return (
    <div className={"container"}>
      <h1>Things You want to do</h1>
      <div>
        <table className={"table"}>
          <thead>
            <tr>
              <td>id</td>
              <td>description</td>
              <td>Is Done?</td>
              <td>targetDate</td>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
            <tr>
              <td>{todos.id}</td>
              <td>{todos.description}</td>
            </tr>
          </tbody>
          <tfoot></tfoot>
        </table>
      </div>
    </div>
  );
}