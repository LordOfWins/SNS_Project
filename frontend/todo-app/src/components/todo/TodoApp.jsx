import "./TodoApp.css";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import React from "react";
import { LogOutComponent } from "./LogOutComponent";
import { HeaderComponent } from "./HeaderComponent";
import { ListTodo } from "./ListTodo";
import { ErrorComponent } from "./ErrorComponent";
import { Welcome } from "./Welcome";
import { Login } from "./Login";
import AuthProvider, { useAuth } from "./security/AuthContext";

function AuthenticateRoute({ children }) {
  const authContext = useAuth();
  if (authContext.isAuthenticated) {
    return children;
  }
  return <Navigate to={"/"} />;
}

export default function TodoApp() {
  return (
    <div className={"TodoApp"}>
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />
          <Routes>
            <Route path={"/"} element={<Login />} />
            <Route path={"/login"} element={<Login />} />
            <Route
              path={"/welcome/:username"}
              element={
                <AuthenticateRoute>
                  <Welcome />
                </AuthenticateRoute>
              }
            />
            <Route
              path={"/todos"}
              element={
                <AuthenticateRoute>
                  <ListTodo />
                </AuthenticateRoute>
              }
            />
            <Route
              path={"/logout"}
              element={
                <AuthenticateRoute>
                  <LogOutComponent />
                </AuthenticateRoute>
              }
            />
            <Route path={"*"} element={<ErrorComponent />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}