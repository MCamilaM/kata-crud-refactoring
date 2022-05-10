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
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    /**
     * Método para actualizar un todo
     * @param todo
     * @return guarda todo
     */
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * Método para eliminar un todo
     * @param id
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }








}
