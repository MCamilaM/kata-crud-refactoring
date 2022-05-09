import React,{createContext,useReducer} from 'react'
import Reducer from './Reducer'
const HOST_API = "http://localhost:8080/api";
const initialState = {
  todo: { list: [], item: {} }
};
const Store = createContext(initialState)

function StoreProvider({children}) {
  const [state,dispatch]=useReducer(Reducer,initialState);
  return (
    <Store.Provider value={{state,dispatch}}>
            {children}
    </Store.Provider>
  )
}

export default StoreProvider

export {Store, initialState,HOST_API}