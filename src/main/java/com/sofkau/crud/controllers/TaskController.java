package com.sofkau.crud.controllers;

import com.sofkau.crud.models.Task;
import com.sofkau.crud.services.TaskService;
import com.sofkau.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase controladora tipo REST para las tareas..
 *
 * @author Mateo Gutierrez <mateog147@hotmail.com>
 * @version 1.0.0 2022/06/17
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TaskController {
    @Autowired
    TodoListService todoListService;

    @Autowired
    TaskService taskService;

    @GetMapping("task")
    public ArrayList<Task> getAllTasks(){
        return taskService.getAll();
    }

    @GetMapping("task/{id}")
    public Optional<Task> getTask(@PathVariable("id") Long id){
        return taskService.getById(id);
    }

    @PostMapping("todolist/{id}/task")
    public Task saveNewTask(@RequestBody Task newTask,@PathVariable("id") Long id) {
        Optional<Task> task = todoListService.getById(id).map(list ->{
            newTask.setList(list);
            return taskService.saveTask(newTask);
        });

        return (task.isPresent())?task.get():null;
    }

    @GetMapping("todolist/{id}/task")
    public ArrayList<Task> getByListId(@PathVariable("id") Long id){
        return taskService.getByList(id);
    }

    @PutMapping("task/{id}")
    public Task updateTask(@PathVariable("id") Long id,@RequestBody Task task){
        return this.taskService.updateInfo(id, task);
    }

    @PutMapping("task/complete/{id}")
    public Task completeTask(@PathVariable("id") Long id){
        return this.taskService.completeTask(id);
    }

    @DeleteMapping("task/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.taskService.deleteTask(id);
        if (ok) {
            return "Se eliminó la tarea con id " + id;
        } else {
            return "No pudo eliminar la tarea con id" + id;
        }
    }

}
