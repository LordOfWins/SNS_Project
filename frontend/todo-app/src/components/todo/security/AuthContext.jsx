//1: Create a Context
import React, { createContext, useContext, useMemo, useState } from "react";
import { apiClient } from "../api/ApiClient";
import { executeBasicAuth } from "../api/ExecuteBasicAuth";

export const AuthContext = createContext(undefined);
export const useAuth = () => useContext(AuthContext);

//put some state in the context

//Share the created context with the app
export default function AuthProvider({ children }) {
  //3: put some state in the context
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const [username, setUsername] = useState(null);

  const [token, setToken] = useState(null);

  async function login(username, password) {
    const basicToken = "Basic " + window.btoa(username + ":" + password);
    try {
      const response = await executeBasicAuth(basicToken);

      if (response.status === 200) {
        setIsAuthenticated(true);
        setUsername(username);
        setToken(basicToken);
        apiClient.interceptors.request.use((config) => {
          config.headers.Authorization = basicToken;
          return config;
        });
        return true;
      } else {
        logout();
        return false;
      }
    } catch (e) {
      logout();
      return false;
    }
  }

  function logout() {
    setIsAuthenticated(false);
    setToken(null);
    setUsername(null);
  }

  const value = useMemo(() => {
    return {
      isAuthenticated,
      login,
      logout,
      username,
      token,
    };
  });
  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>; //컨텍스트에 전달
}