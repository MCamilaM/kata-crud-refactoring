package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repositories.ITodoListRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    /**
     * Repositorios
     */
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ITodoListRepository iTodoListRepository;


    /**
     * Método para obtener todos los todos
     * @return lista de todos
     */
    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    /**
     * Método para guardar un todo
     * @param todo
     * @return todo
     */
    public TodoList saveTodo(Todo todo) {
        TodoList todoList = iTodoListRepository.findById(todo.getGroupListId()).get();
        todoList.addTodo(todo);
        todoRepository.save(todo);
        return iTodoListRepository.save(todoList);
    }

    /**
     * Método para actualizar un todo
     * @param note
     * @return guarda todo
     */
    public Todo updateTodo(Todo note) {
        return todoRepository.save(note);
    }

    /**
     * Método para eliminar un todo
     * @param id
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

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
    public void deleteTodoList(Long id) {
        TodoList todoListToBeDeleted = iTodoListRepository.findById(id).get();
        if(todoListToBeDeleted.getTodos().size() >= 0){
            todoListToBeDeleted.getTodos().forEach(todo -> todoRepository.deleteById(todo.getId()));
        }
        iTodoListRepository.deleteById(id);
    }


    /**
     * Método para obtener todos los TodoLists
     * @return todolist
     */
    public List<TodoList> getTodoLists() {
        return iTodoListRepository.findAll();
    }
}
