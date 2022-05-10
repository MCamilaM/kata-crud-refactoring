
function reducer(state, action) {
  
  switch (action.type) {
    case "update-item":
      const todoUpItem = state.todo;
      const listUpdateEdit = todoUpItem.list.map((item) => {
        if (item.id === action.item.id) {
          return action.item;
        }
        return item;
      });
      todoUpItem.list = listUpdateEdit;
      todoUpItem.item = {};
      return { ...state, todo: todoUpItem };
    case "delete-item":
      const todoUpDelete = state.todo;
      const listUpdate = todoUpDelete.list.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDelete.list = listUpdate;
      return { ...state, todo: todoUpDelete };

    case "update-listtodos":
      const todoUpList = state.todo;
      todoUpList.list = action.list;
      return { ...state, todo: todoUpList };


    case "edit-item":
      const todoUpEdit = state.todo;
      todoUpEdit.item = action.item;
      return { ...state, todo: todoUpEdit };

    case "add-item":
      const todoUp = state.todo.list;
      todoUp.push(action.item);
      return { ...state, todo: { list: todoUp, item: {} } };

    case "add-todoList":
      const gruopList = state.todoList.list;
      gruopList.push(action.item);
      return { ...state, todoList: { list: gruopList, item: {} } };

    case "update-list":
      const listTodos = state.todoList;
      listTodos.list = action.list;
      return { ...state, todoList: listTodos };

    case "delete-list":
      const groupListDelete = state.todo;
      const listUpdater = groupListDelete.list.filter((item) => {
        return item.id_groupList !== action.id_groupList;
      });
      groupListDelete.list = listUpdater;
      return { ...state, todo: groupListDelete };

    default:
      return state;
  }
}

export default reducer;