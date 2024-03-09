package com.devtonho.task.service;

import com.devtonho.task.entity.Task;
import com.devtonho.task.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    void canSaveTask() {
        // given
        Task task = new Task(
                1,
                "Title 1",
                "Description for Task 1",
                LocalDateTime.now(),
                "In Progress"
        );

        // when
        underTest.saveTask(task);

        // then
        ArgumentCaptor<Task> taskArgumentCaptor =
                ArgumentCaptor.forClass(Task.class);

        verify(taskRepository)
                .save(taskArgumentCaptor.capture());

        Task captorValue = taskArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(task);
    }

    @Test
    void canSaveTasks() {
        // given
        List<Task> tasks = Arrays.asList(
                new Task(
                        1,
                        "Title 1",
                        "Description for Task 1",
                        LocalDateTime.now(),
                        "In Progress"
                ),
                new Task(
                        2,
                        "Title 2",
                        "Description for Task 2",
                        LocalDateTime.now(),
                        "In Progress"
                )
        );

        // when
        underTest.saveTasks(tasks);

        // then
        ArgumentCaptor<List<Task>> listTaskArgumentCaptor =
                ArgumentCaptor.forClass(List.class);

        verify(taskRepository).saveAll(listTaskArgumentCaptor.capture());

        List<Task> captorValues = listTaskArgumentCaptor.getValue();

        assertThat(captorValues).isEqualTo(tasks);
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
    void canDeleteTask() {
        // given
        int id = 1;

        // when
        underTest.deleteTask(id);

        // then
        verify(taskRepository).deleteById(id);
    }

    @Test
    void canUpdateTask() {
        // given
        Task task = new Task(
                1,
                "Title 1",
                "Description for Task 1",
                LocalDateTime.now(),
                "In Progress"
        );

        // when
        when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
        underTest.updateTask(task);

        // then
        ArgumentCaptor<Task> taskArgumentCaptor =
                ArgumentCaptor.forClass(Task.class);

        verify(taskRepository)
                .save(taskArgumentCaptor.capture());

        Task captorValue = taskArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(task);
    }
}