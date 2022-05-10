package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repositories.ITodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private ITodoListRepository iTodoListRepository;


    /**
     * Método para guardar un TodoList
     * @param todoList
     * @return todolist
     */
    public TodoList saveTodoList(TodoList todoList) {
        return iTodoListRepository.save(todoList);
    }

    /**
     * Método para actualizar un TodoList
     * @param todoList
     * @return todolist
     */
    public TodoList updateTodoLists(TodoList todoList) {
        return iTodoListRepository.save(todoList);
    }

    /**
     * Método para eliminar un TodoList
     * @param id
     */
    public void delete(Long id) {
         iTodoListRepository.delete(get(id));
    }
    /**
     * Método para obtener todos los TodoLists
     * @return todolist
     */
    public List<TodoList> getTodoLists() {
        return iTodoListRepository.findAll();
    }

    public TodoList get(Long id){
        return iTodoListRepository.findById(id).orElseThrow();
    }
}
