package co.com.sofka.crud.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Todo")
@Table(name="todo")
@Data
/**
 * @Author: Camila Morales
 */
public class Todo {
    /**
     * Propiedades
     */
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean completed;
    private Long groupListId;

    /**
     *Métodos getters y setters
     */
    public Long getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(Long groupListId) {
        this.groupListId = groupListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
