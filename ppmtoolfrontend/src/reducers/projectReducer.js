import { GET_PROJECTS, GET_PROJECT } from "../actions/types";

const initialState = {
  projects: [],
  project: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_PROJECTS:
      // return the state, and the projects array.
      return {
        ...state,
        projects: action.payload
      };

    case GET_PROJECT:
      return {
        ...state,
        project: action.payload
      };

    default:
      return state;
  }
}
