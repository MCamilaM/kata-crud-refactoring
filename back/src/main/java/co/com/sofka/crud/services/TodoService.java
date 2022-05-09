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

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ITodoListRepository iTodoListRepository;


    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public TodoList saveTodo(Todo todo) {
        TodoList todoList = iTodoListRepository.findById(todo.getGroupListId()).get();
        todoList.addTodo(todo);
        todoRepository.save(todo);
        return iTodoListRepository.save(todoList);
    }

    public Todo updateTodo(Todo note) {
        return todoRepository.save(note);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public TodoList saveTodoList(TodoList todoList) {
        return iTodoListRepository.save(todoList);
    }

    public TodoList updateTodoLists(TodoList todoList) {
        return iTodoListRepository.save(todoList);
    }

    public void deleteTodoList(Long id) {
        TodoList todoListToBeDeleted = iTodoListRepository.findById(id).get();
        if(todoListToBeDeleted.getTodos().size() >= 0){
            todoListToBeDeleted.getTodos().forEach(todo -> todoRepository.deleteById(todo.getId()));
        }
        iTodoListRepository.deleteById(id);
    }


    public List<TodoList> getTodoLists() {
        return iTodoListRepository.findAll();
    }
}
