package com.example.lab5.repositories;


import com.example.lab5.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository  extends CrudRepository<Task, Long> {
}
