package com.sofkau.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Task.
 * Entidad que representa las tareas.
 *
 * @author Mateo Gutierrez <mateog147@hotmail.com>
 * @version 1.0.0 2022/06/17
 * @since 1.0.0
 */
@Entity
@Table(name = "tasks")
public class Task {
    /**
     * Identificado autoincremental.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    /**
     * Descripcción de la tarea.
     */
    private String description;
    /**
     * Atributo para saber si esta completa o no
     */
    private Boolean isComplete;

    /**
     * Columna que asocia una tarea a una lista.
     * La lista puede tener de 0 a n Tareas.
     * Una tarea solo puede tener una lista.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "list_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TodoList list;

    //Constructor
    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public Task() {
        this.isComplete = false;
    }

    //Setters y getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public TodoList getList() {
        return list;
    }

    public void setList(TodoList list) {
        this.list = list;
    }
}
