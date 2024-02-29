package com.devtonho.taskmanagementsystem.repository;

import com.devtonho.taskmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByDescription(String description);
}
