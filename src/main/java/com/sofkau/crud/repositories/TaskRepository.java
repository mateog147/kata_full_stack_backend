package com.sofkau.crud.repositories;

import com.sofkau.crud.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TaskRepository extends CrudRepository<Task, Long> {
    ArrayList<Task> findByListId(Long listId);
}
