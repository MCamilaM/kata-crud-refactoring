import React, { useContext, useReducer, useEffect, useRef, useState, createContext, Fragment } from 'react';
import StoreProvider from '../src/components/StoreProvider';
import Form from './components/Form'
import CreateList from './components/CreateList'
function App() {
   
  return (
    <StoreProvider>
        <h1>Dashboard</h1>
        <Form/>
        <CreateList/>
    </StoreProvider>
  )
}

export default App;
