import React, { createContext, useReducer } from 'react'
import Reducer from "./Reducer"
export const HOST_API = "http://localhost:8080/api";
export const initialState = {
  todo: { list: [], item: {} },
  todoList: { list: [], item: {} }
};
export const Store = createContext(initialState)

function StoreProvider({ children }) {
  const [state, dispatch] = useReducer(Reducer, initialState);
  return (
    <Store.Provider value={{ state, dispatch }}>
      {children}
    </Store.Provider>
  )
}

export default StoreProvider

