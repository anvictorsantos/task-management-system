package com.devtonho.taskmanagementsystem.controller;

import com.devtonho.taskmanagementsystem.entity.Task;
import com.devtonho.taskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task){
        return service.saveTask(task);
    }

    @PostMapping("/addTasks")
    public List<Task> addTasks(@RequestBody List<Task> task){
        return service.saveTasks(task);
    }

    @GetMapping("/tasks")
    public List<Task> findAllTasks(){
        return service.getTasks();
    }

    @GetMapping("/taskById/{id}")
    public Task findTaskById(@PathVariable int id){
        return service.getTaskById(id);
    }

    @GetMapping("/task/{description}")
    public Task findTaskByDescription(@PathVariable String description){
        return service.getTaskByDescription(description);
    }

    @PutMapping("/updateTask")
    public String updateTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id){
        return service.deleteTask(id);
    }
}
