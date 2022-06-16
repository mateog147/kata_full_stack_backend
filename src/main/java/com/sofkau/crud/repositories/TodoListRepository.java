package com.sofkau.crud.repositories;

import com.sofkau.crud.models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {
    public abstract ArrayList<TodoList> findByIsActive(Boolean flag);
    //public abstract ArrayList<TodoList> findByEmail(String email);
}