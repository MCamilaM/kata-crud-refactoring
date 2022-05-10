import React, { useContext, useEffect, Fragment} from "react";
import { HOST_API, Store } from "./StoreProvider";
import FormItem from "./FormItem";
import CreateItem from "./CreateItem"

const CreateList = () => {
  const { dispatch, state: { todoList } } = useContext(Store);
  const lista = todoList.list;
  

  useEffect(() => {
    fetch(HOST_API + "/todolist")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list })
      })
  }, [dispatch]);


  const onDelete = (groupListId) => {
    fetch(HOST_API + "/" + groupListId + "/todolist", {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-list", groupListId })
    })
    //const remove = document.getElementById("columnaLista")
    //remove.removeChild(document.getElementById(id_todoList))
  };

  return lista.map((todoList) => {
    return (
      <Fragment key={todoList.groupListId}>
        <div className="col-md-6 mb-2" id={todoList.groupListId}>
          <div className="card custom-card">
            <div className="m-2 rounded bkGrey" key={todoList.groupListId}>
              <div className="m-2">
                <h2>{todoList.name}</h2>
                <button
                  className="btn btn-outline-danger"
                  onClick={() => onDelete(todoList.groupListId)}
                  
                >
                  {console.log("estamos aqui "+todoList.groupListId)}
                  Eliminar Lista
                </button>
              </div>
              <FormItem id={todoList} />
              <CreateItem id={todoList} />
            </div>
          </div>
        </div>
      </Fragment>
    );
  });
}

export default CreateList
