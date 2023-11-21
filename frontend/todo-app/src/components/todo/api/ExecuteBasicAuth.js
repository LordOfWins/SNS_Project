import { apiClient } from "./ApiClient";

export const executeBasicAuth = (token) =>
  apiClient.get(`/basicauth`, {
    headers: { Authorization: token },
  });