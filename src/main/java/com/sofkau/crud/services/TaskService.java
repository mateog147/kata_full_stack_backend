package com.sofkau.crud.services;

import com.sofkau.crud.models.Task;
import com.sofkau.crud.models.TodoList;
import com.sofkau.crud.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase de servicio para las tareas.
 * Cuenta con con los metodos para guardar, editar, eliminar y actualizar las tareas de la base de datos.
 * Usa los metodos expuestos por Hibernate al implementar la interface TaskInterface.
 *
 * @author Mateo Gutierrez <mateog147@hotmail.com>
 * @version 1.0.0 2022/06/17
 * @since 1.0.0
 */
@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public ArrayList<Task> getAll(){
        return (ArrayList<Task>) taskRepository.findAll();
    }

    public Optional<Task> getById(Long id){
        return taskRepository.findById(id);
    }

    public ArrayList<Task> getByList(Long id){
        return (ArrayList<Task>) taskRepository.findByListId(id);
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    /**
     * El metodo actualizar valida que exista el Id.
     * Si no existe lo creara dentro de la base de datos
     * @param id
     * @param requestTask
     * @return
     */
    public Task updateInfo(Long id, Task requestTask){
        return taskRepository.findById(id)
                .map(task -> {
                    task.setDescription(requestTask.getDescription());
                    task.setComplete(requestTask.getComplete());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    requestTask.setId(id);
                    return taskRepository.save(requestTask);
                });
    }

    /**
     * Este metodo cambia el atributo boleano IsComplete.
     * true -> false.
     * false -> true.
     * @param id
     * @return
     */
    public Task completeTask(Long id){
        return taskRepository.findById(id)
                .map(task -> {
                    task.setComplete(!task.getComplete());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    public boolean deleteTask(Long id) {
        try{
            taskRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
