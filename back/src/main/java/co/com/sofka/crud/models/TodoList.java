package co.com.sofka.crud.models;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="TodoList")
@Table(name="todolist")
@Data
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(
            cascade=CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Todo> todos=new ArrayList<>();

    public TodoList addTodo(Todo todo){
        this.todos.add(todo);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}


