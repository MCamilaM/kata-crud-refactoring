package co.com.sofka.crud.controller;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.getTodos();
    }

    @GetMapping("api/todolist")
    public List<TodoList> getAllOperations(){
        return service.getTodoLists();
    }

    @PostMapping(value = "api/todo")
    public TodoList saveTodo(@RequestBody Todo todo){
        return service.saveTodo(todo);
    }

    @PostMapping("api/todolist")
    public TodoList saveOperation(@RequestBody TodoList todoList){
        return service.saveTodoList(todoList);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.updateTodo(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @PutMapping("api/todolist")
    public TodoList updateTodoList(@RequestBody TodoList todoList){
        return service.updateTodoLists(todoList);
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void deleteTodo(@PathVariable("id")Long id){
        service.deleteTodo(id);
    }

    @DeleteMapping("api/{id}/todolist")
    public void deleteTodoList(@PathVariable Long id) {
        service.deleteTodoList(id);
    }

    /*@GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }*/

}
