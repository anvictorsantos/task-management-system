package com.devtonho.task.repository;

import com.devtonho.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByDescription(String description);
}
