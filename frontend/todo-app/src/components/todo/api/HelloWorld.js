import { apiClient } from "./ApiClient";

export const getHelloWorldBean = () => apiClient.get("/hello-world-bean");

export const getHelloWorldPathVariable = (username, token) =>
  apiClient.get(
    `/hello-world/path-variable/${username}`,
    // , {
    // headers: { Authorization: token },
    // }
  );