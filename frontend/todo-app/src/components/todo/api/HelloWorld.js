import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8080/",
});
export const getHelloWorldBean = () => apiClient.get("/hello-world-bean");

export const getHelloWorldPathVariable = (username) =>
  apiClient.get(`/hello-world/path-variable/${username}`);