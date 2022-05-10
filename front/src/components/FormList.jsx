import React, { useContext, useRef, useState } from "react";
import { HOST_API, Store } from "./StoreProvider";


const FormList = () => {
 
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todoList },
  } = useContext(Store);
  const item = todoList.item;
  const [state, setState] = useState(item);



  const onAdd = (event) => {
    event.preventDefault();
    const request = {
      name: state.name,
      id_todoList: null,
    };
    console.log(request)
    if (state.name === undefined || state.name === "") {
      window.alert("Ingresa el nombre de la lista")
    } else {
      fetch(HOST_API + "/todolist", {
        method: "POST",
        body: JSON.stringify(request),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((res) => res.json())
        .then((todoList) => {
          dispatch({ type: "add-todoList", item: todoList });
          setState({ name: "" });
          formRef.current.reset();
        });
    }
  };
  return (
    <div className="row">
      <div className="col-2"></div>
      <div className="col-8 ml-3">
        <form ref={formRef}>
          <div className="input-group mb-2">
            <input
              type="text"
              name="name"
              placeholder="Ingresa una nueva Lista de ToDo"
              className="form-control"
              onChange={(event) => {
                setState({ ...state, name: event.target.value });
              }}
            ></input>
            <button onClick={onAdd} className="btn btn-primary m-1">
              Agregar Nueva Lista
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default FormList;