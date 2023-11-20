import axios from "axios";

const apiClient = axios.create({
    baseURL: "http://localhost:8080/",
});
export const getHelloWorldBean = () =>
    apiClient.get("http://localhost:8080/hello-world-bean");

export const getHelloWorldPathVariable = (username) =>
    apiClient.get(`http://localhost:8080/hello-world/path-variable/${username}`);