package com.devtonho.task.service;

import com.devtonho.task.repository.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    private TaskService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TaskService(taskRepository);
    }

    @Test
    @Disabled
    void saveTask() {
    }

    @Test
    @Disabled
    void saveTasks() {
    }

    @Test
    void canGetTasks() {
        // when
        underTest.getTasks();

        // then
        verify(taskRepository).findAll();
    }

    @Test
    void canGetTaskById() {
        // given
        int id = 1;

        // when
        underTest.getTaskById(id);

        // then
        verify(taskRepository).findById(id);
    }

    @Test
    void canGetTaskByDescription() {
        // given
        String description = "Description for Task 1";

        // when
        underTest.getTaskByDescription(description);

        // then
        verify(taskRepository).findByDescription(description);
    }

    @Test
    @Disabled
    void deleteTask() {
    }

    @Test
    @Disabled
    void updateTask() {
    }
}