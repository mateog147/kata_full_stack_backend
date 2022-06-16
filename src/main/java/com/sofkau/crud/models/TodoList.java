package com.sofkau.crud.models;

import javax.persistence.*;

@Entity
@Table(name = "lists")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private Boolean isActive;

    public TodoList() {
        this.isActive = true;
    }

    public TodoList(String name) {
        this.name = name;
        this.isActive = true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}