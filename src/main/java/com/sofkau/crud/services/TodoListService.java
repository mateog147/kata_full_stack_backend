package com.sofkau.crud.services;

import com.sofkau.crud.models.TodoList;
import com.sofkau.crud.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Clase de servicio para las listas TO-DO.
 * Cuenta con con los metodos para guardar, editar y actualizar las tareas de la base de datos.
 * Usa los metodos expuestos por Hibernate al implementar la interface TodoListInterface.
 *
 * @author Mateo Gutierrez <mateog147@hotmail.com>
 * @version 1.0.0 2022/06/17
 * @since 1.0.0
 */
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

    /**
     * El metodo actualizar valida que exista el Id.
     * Si no existe lo creara dentro de la base de datos.
     * @param id
     * @param newList
     * @return
     */
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

    /**
     * El metodo borrar no hace borrado fisico de la lista.
     * En su lugar hace borrado logico pasando es atributo IsActive a false.
     * @param id
     * @return
     */
    public boolean deleteList(Long id) {
        Optional<TodoList> saveList = todoListRepository.findById(id)
                .map(list -> {
                    list.setActive(false);
                    return todoListRepository.save(list);
                });
        return saveList.isPresent();
    }

    
}