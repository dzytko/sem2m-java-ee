package com.example.lab5.repositories;


import com.example.lab5.entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByDone(boolean done);

    List<Task> findByCostLessThan(double cost);

    List<Task> findByCostBetween(double minCost, double maxCost);
}
