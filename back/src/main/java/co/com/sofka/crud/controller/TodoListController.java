package co.com.sofka.crud.controller;

import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("api/todolist")
    public List<TodoList> getAllTodoList(){
        return todoListService.getTodoLists();
    }

    @PostMapping("api/todolist")
    public TodoList saveTodolist(@RequestBody TodoList todoList){
        return todoListService.saveTodoList(todoList);
    }

    @PutMapping("api/todolist")
    public TodoList updateTodoList(@RequestBody TodoList todoList){
        return todoListService.updateTodoLists(todoList);
    }

    @DeleteMapping("api/{id}/todolist")
    public void delete(@PathVariable("id") Long id) {
        todoListService.delete(get(id));
    }

    @GetMapping(value = "api/{id}/todolist")
    public Long get(@PathVariable("id") Long id) {
        return todoListService.get(id).getIdTodoList();
    }
}
