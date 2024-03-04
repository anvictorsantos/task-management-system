package com.devtonho.task.repository;

import com.devtonho.task.entity.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindByDescriptionWhenExists() {
        // given
        String description = "Description for Task 1";
        Task task = new Task(
                1,
                "Title 1",
                description,
                LocalDateTime.now(),
                "In Progress"
        );
        underTest.save(task);

        // when
        Task expected = underTest.findByDescription(description);

        // then
        assertThat(expected).isEqualTo(task);
    }

    @Test
    void itShouldNotFindByDescriptionWhenDoesNotExists() {
        // given
        String description = "Description for Task 1";

        // when
        Task expected = underTest.findByDescription(description);

        // then
        assertThat(expected).isNull();
    }
}
