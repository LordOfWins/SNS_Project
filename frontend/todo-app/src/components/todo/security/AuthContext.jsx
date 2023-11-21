//1: Create a Context
import React, { createContext, useContext, useMemo, useState } from "react";

export const AuthContext = createContext(undefined);
export const useAuth = () => useContext(AuthContext);

//put some state in the context

//Share the created context with the app
export default function AuthProvider({ children }) {
  //3: put some state in the context
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const [username, setUsername] = useState(null);

  function login(username, password) {
    if (username === "test" && password === "test") {
      setIsAuthenticated(true);
      setUsername(username);
      return true;
    } else {
      setIsAuthenticated(false);
      setUsername(null);
      return false;
    }
  }

  function logout() {
    setIsAuthenticated(false);
  }

  const value = useMemo(() => {
    return {
      isAuthenticated,
      login,
      logout,
      username,
    };
  });
  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>; //컨텍스트에 전달
}