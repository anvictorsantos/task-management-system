package com.devtonho.task.service;

import com.devtonho.task.entity.Task;
import com.devtonho.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task saveTask(Task task){
        return repository.save(task);
    }

    public List<Task> saveTasks(List<Task> tasks){
        return repository.saveAll(tasks);
    }

    public List<Task> getTasks(){
        return repository.findAll();
    }

    public Task getTaskById(int id){
        return repository.findById(id).orElse(null);
    }

    public Task getTaskByDescription(String description){
        return repository.findByDescription(description);
    }

    public String deleteTask(int id){
        repository.deleteById(id);
        return "{ \"message\": \"Task removed successfully\", \"id\": " + id + " }";
    }

    public String updateTask(Task task){
        Task existingTask = repository.findById(task.getId()).orElse(null);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setStatus(task.getStatus());
        repository.save(existingTask);
        return "{ \"message\": \"Task updated successfully\", \"id\": " + task.getId() + " }";
    }
}
