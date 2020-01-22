import axios from "axios";
import { GET_ERRORS, GET_PROJECTS } from "./types";

// history is what is going to allow to redirect once the form is submitted (redirect to dashboard)
// dispatch is what we're going to be returning
// async = function will return a promise
// await = wait til promise is rendered
export const createProject = (project, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8080/api/project", project);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};
//summary: createProject function will return a promise(async).
//try posting to the backend server with project obj parameter and if it works, take the user back to the dashboard
// or else catch the error by dispatching GET_ERRORS reducer

export const getProjects = () => async dispatch => {
  const res = await axios.get("http://localhost:8080/api/project/all");
  dispatch({
    type: GET_PROJECTS,
    payload: res.data
  });
};
