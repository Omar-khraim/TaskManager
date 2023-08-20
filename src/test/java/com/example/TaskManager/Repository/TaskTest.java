package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Task;
import com.example.TaskManager.Entity.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskTest {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @AfterEach
    void clear(){
        userRepo.deleteAll();
        taskRepo.deleteAll();
    }

    @Test
    void hasTasksForUser() {

        //Given
        Users user = Users.builder()
                .firstName("Omar")
                .lastName("Khraim")
                .email("omarKhraim@gmial.com")
                .password("12346").build();

        userRepo.save(user);

        Task task = Task.builder().user(user)
                .description("Test")
                .dueDate(LocalDate.now())
                .estimationTime((byte) 1)
                .name("name Test")
                .build();
        taskRepo.save(task);
        // When
        List<Task> tasks = taskRepo.findByUser_Id(user.getId());

        // Then
        assertThat(tasks).isNotNull();
        assertThat(tasks).isNotEmpty();
        assertThat(tasks).hasSize(1);

    }

    @Test
    void iDoesNotHasTasksForUser() {

        //Given

        Task task = Task.builder()
                .description("Test")
                .dueDate(LocalDate.now())
                .estimationTime((byte) 1)
                .name("name Test")
                .build();
        taskRepo.save(task);
        // When
        List<Task> tasks = taskRepo.findByUser_Id(1);

        // Then
        assertThat(tasks).isEmpty();

    }
}
