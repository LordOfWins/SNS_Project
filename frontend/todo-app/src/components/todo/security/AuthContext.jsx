//1: Create a Context
import React, { createContext, useContext, useState } from "react";

export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

//put some state in the context

//Share the created context with the app
export default function AuthProvider({ children }) {
  //3: put some state in the context
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  function login(username, password) {
    if (username === "test" && password === "test") {
      setIsAuthenticated(true);
      return true;
    } else {
      setIsAuthenticated(false);
      return false;
    }
  }

  function logout() {
    setIsAuthenticated(false);
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  ); //컨텍스트에 전달
}