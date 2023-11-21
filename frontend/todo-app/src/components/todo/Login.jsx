import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export function Login() {
  const [savedName, setSavedName] = useState("test");
  const [savedPassword, setSavedPassword] = useState("test");

  const [showErrorPageMessage, setShowErrorPageMessage] = useState(false);

  const navigate = useNavigate();

  const authContext = useAuth();

  function changingName(e) {
    setSavedName(e.target.value);
  }

  function changingPassword(e) {
    setSavedPassword(e.target.value);
  }

  async function handleSubmit() {
    if (await authContext.login(savedName, savedPassword)) {
      navigate(`/welcome/${savedName}`);
    } else {
      setShowErrorPageMessage(true);
    }
  }

  return (
    <div className={"Login"}>
      <h1>Time to Login</h1>
      {showErrorPageMessage && (
        <div className="errorMeessage">
          Authentication Failed, Please check your credential
        </div>
      )}
      <div className={"LoginForm"}>
        <div>
          <label>
            User Name{}
            <input
              type="text"
              name={"username"}
              value={savedName}
              onChange={changingName}
            />
          </label>
        </div>
        <div>
          <label>
            Password{}
            <input
              type="password"
              name={"password"}
              value={savedPassword}
              onChange={changingPassword}
            />
          </label>
        </div>

        <div>
          <button type="submit" className={"login"} onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}