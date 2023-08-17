package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskTest {

    @Autowired
    TaskRepository taskRepo;

    @Test
    public void testGetUserTasks(){
        List<Task> tasks = taskRepo.findByUser_Id(1);
        assertThat(tasks).hasSize(1);

    }
}
