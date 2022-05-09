package co.com.sofka.crud.models;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="TodoList")
@Table(name="todolist")
@Data
/**
 * @Author: Camila Morales
 */
public class TodoList {

    /**
     * Propiedades
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    /**
     * Relación uno a muchos
     */
    @OneToMany(
            cascade=CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Todo> todos=new ArrayList<>();

    /**
     * Metodo para agregar un todo
     * @param todo
     * @return todolist
     */
    public TodoList addTodo(Todo todo){
        this.todos.add(todo);
        return this;
    }

    /**
     * Métodos getters y setters
     */
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


