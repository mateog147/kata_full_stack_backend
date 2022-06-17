package com.sofkau.crud.models;

import javax.persistence.*;

/**
 * TodoList.
 * Entidad que representa las listas TO-DO.
 *
 * @author Mateo Gutierrez <mateog147@hotmail.com>
 * @version 1.0.0 2022/06/17
 * @since 1.0.0
 */
@Entity
@Table(name = "lists")
public class TodoList {
    /**
     * Identificador de la lista.
     * AutoInremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    /**
     * Atributo del nombre de la lista.
     */
    private String name;
    /**
     * Atributo boleano que define si la lista esta activa o no.
     * por defecto true
     */
    private Boolean isActive;

    /**
     * Constructor sin argumentos.
     * IsActive por defecto en true.
     * El id es autoincremental.
     */
    public TodoList() {
        this.isActive = true;
    }
    /**
     * Constructor.
     * IsActive por defecto en true
     * El id es autoincremental.
     */
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