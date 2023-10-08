package com.example.lab5.controllers;

import com.example.lab5.entities.Task;
import com.example.lab5.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PageController {
    private final TaskRepository taskRepository;

    @GetMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }

    @GetMapping("/taskList")
    @ResponseBody
    public String taskList() {
        StringBuilder response = new StringBuilder();
        var newTask = new Task();
        newTask.setName("Task 1");
        newTask.setDescription("Description 1");
        newTask.setCost(100d);
        newTask.setDone(false);
        taskRepository.save(newTask);

        for (var task : taskRepository.findAll()) {
            response.append(task).append("<br>");
        }
        return response.toString();
    }

    @GetMapping("/delete/{taskId}")
    @ResponseBody
    public String deleteTask(@PathVariable Long taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            return "Task with ID " + taskId + " has been deleted.";
        }
        else {
            return "Task with ID " + taskId + " not found.";
        }
    }

    @GetMapping("/done/{done}")
    @ResponseBody
    public String findTasksByDone(@PathVariable boolean done) {
        List<Task> tasks = taskRepository.findByDone(done);
        var response = new StringBuilder();
        for (var task : tasks) {
            response.append(task).append("<br>");
        }
        return response.toString();
    }

    @GetMapping("/cost/lessthan/{cost}")
    @ResponseBody
    public String findTasksByCostLessThan(@PathVariable double cost) {
        List<Task> tasks = taskRepository.findByCostLessThan(cost);
        var response = new StringBuilder();
        for (var task : tasks) {
            response.append(task).append("<br>");
        }
        return response.toString();
    }

    @GetMapping("/cost/between/{minCost}/{maxCost}")
    @ResponseBody
    public String findTasksByCostBetween(
            @PathVariable double minCost,
            @PathVariable double maxCost
    ) {
        List<Task> tasks = taskRepository.findByCostBetween(minCost, maxCost);
        var response = new StringBuilder();
        for (var task : tasks) {
            response.append(task).append("<br>");
        }
        return response.toString();
    }
}