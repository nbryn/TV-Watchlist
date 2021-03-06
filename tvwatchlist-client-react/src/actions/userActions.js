import axios from "axios";
import { GET_ERRORS, SET_USER } from "./types";
import jwt_decode from "jwt-decode";
import setToken from "../security/setToken";

export const newUser = (user, history) => async dispatch => {
  try {
    await axios.post("https://tv-watchlist.herokuapp.com/users/signup", user);
    history.push("/signin");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const signIn = signInRequest => async dispatch => {
  try {
    const res = await axios.post(
      "https://tv-watchlist.herokuapp.com/users/signin",
      signInRequest
    );

    const { token } = res.data;
    localStorage.setItem("jwtToken", token);

    setToken(token);
    const decodedToken = jwt_decode(token);

    dispatch({
      type: SET_USER,
      payload: decodedToken
    });
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const signOut = () => dispatch => {
  localStorage.removeItem("jwtToken");
  setToken(false);
  dispatch({
    type: SET_USER,
    payload: {}
  });
};
