package com.example.lab5.controllers;

import com.example.lab5.entities.Task;
import com.example.lab5.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class PageController {
    private final TaskRepository taskRepository;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }

    @RequestMapping("/taskList")
    @ResponseBody
    public String taskList() {
        StringBuilder response = new StringBuilder();
        var newTask = new Task();
        newTask.setName("Task 1");
        newTask.setDescription("Description 1");
        newTask.setCost(100d);
        newTask.setDone(false);
        taskRepository.save(newTask);

        for(var task: taskRepository.findAll()) {
            response.append(task).append("<br>");
        }
        return response.toString();
    }

}