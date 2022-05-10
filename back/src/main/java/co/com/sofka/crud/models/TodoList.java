package co.com.sofka.crud.models;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    private Long idTodoList;
    private String name;

    /**
     * Relación uno a muchos
     */
    @OneToMany(
            cascade=CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "groupListId")
    private List<Todo> todos;


}


