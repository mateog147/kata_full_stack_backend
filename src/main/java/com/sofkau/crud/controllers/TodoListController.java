package com.sofkau.crud.controllers;

import com.sofkau.crud.models.TodoList;
import com.sofkau.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;


/**
 * Clase controladora tipo REST para las listas TO-DO.
 *
 * @author Mateo Gutierrez <mateog147@hotmail.com>
 * @version 1.0.0 2022/06/17
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/todolist")
public class TodoListController {
    @Autowired
    TodoListService todoListService;

    @GetMapping()
    public ArrayList<TodoList> getActiveLists() {
        return todoListService.getAllActives();
    }

    @PostMapping()
    public TodoList saveNewList(@RequestBody TodoList list) {
        return this.todoListService.saveList(list);
    }

    @PutMapping("/{id}")
    public TodoList updateList(@PathVariable("id") Long id, @RequestBody TodoList list){
        return this.todoListService.updateInfo(id, list);
    }

    @GetMapping(path = "/{id}")
    public Optional<TodoList> getOneList(@PathVariable("id") Long id) {
        return this.todoListService.getById(id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.todoListService.deleteList(id);
        if (ok) {
            return "Se eliminĂ³ la lista con id " + id;
        } else {
            return "No pudo eliminar la lista con id " + id;
        }
    }


}