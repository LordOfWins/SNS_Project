import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import React, { useEffect, useState } from "react";
import { createTodo, readTodo, updateTodo } from "./api/TodoApiService";
import { ErrorMessage, Field, Form, Formik } from "formik";
import moment from "moment";

export default function TodoComponent() {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");
  const authContext = useAuth();
  const navigate = useNavigate();
  const username = authContext.username;

  useEffect(() => getTodo(), [id]);

  function getTodo() {
    if (id !== -1) {
      readTodo(username, [id])
        .then((response) => {
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
        })
        .catch((error) => console.log(error));
    }
  }

  function onSubmit(values) {
    console.log(values);
    const todo = {
      id: id,
      username: username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };
    console.log(todo);
    if (id === -1) {
      createTodo(username, todo)
        .then((response) => {
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    } else {
      updateTodo(username, id, todo)
        .then((response) => {
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    }
  }

  function validate(values) {
    let errors = {
      // description: "Enter a valid description",
      // targetDate: "Enter a valid targetDate",
    };
    if (values.description.length < 5) {
      errors.description = "Enter at least 5 letters";
    }
    if (
      values.targetDate == null ||
      values.targetDate === "" ||
      moment(values.targetDate).isValid()
    ) {
      errors.targetDate = "Enter a valid targetDate";
    }
    console.log(values);
    return errors;
  }

  return (
    <div className={"container"}>
      <h1>Enter Todo</h1>

      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name={"description"}
                component={"div"}
                className={"alert alert-danger"}
              />
              <ErrorMessage
                name={"targetDate"}
                component={"div"}
                className={"alert alert-danger"}
              />
              <fieldset className="form-group">
                <label>
                  Description
                  <Field
                    type="text"
                    className={"form-control"}
                    name={"description"}
                  />
                </label>
              </fieldset>
              <fieldset className={"form-group"}>
                <label>
                  Target Date
                  <Field
                    type="date"
                    className={"form-control"}
                    name={"targetDate"}
                  />
                </label>
              </fieldset>
              <div>
                <button className={"btn btn-success m-3"} type={"submit"}>
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}