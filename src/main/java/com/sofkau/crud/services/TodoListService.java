package com.sofkau.crud.services;

import com.sofkau.crud.models.TodoList;
import com.sofkau.crud.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TodoListService {
    @Autowired
    TodoListRepository todoListRepository;
    
    public ArrayList<TodoList> getAll(){
        return (ArrayList<TodoList>) todoListRepository.findAll();
    }

    public TodoList saveList(TodoList list){
        return todoListRepository.save(list);
    }

    public Optional<TodoList> getById(Long id){
        return todoListRepository.findById(id);
    }


    public ArrayList<TodoList>  getAllActives() {
        return todoListRepository.findByIsActive(true);
    }

    public TodoList updateInfo(Long id, TodoList newList){
        return todoListRepository.findById(id)
                .map(list -> {
                    list.setName(newList.getName());
                    list.setActive(newList.getActive());
                    return todoListRepository.save(list);
                })
                .orElseGet(() -> {
                    newList.setId(id);
                    return todoListRepository.save(newList);
                });
    }


    public boolean deleteList(Long id) {
        try{
            todoListRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    
}