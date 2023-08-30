package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Project;
import com.example.TaskManager.Entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProjectRepoTest {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private UserRepository userRepo;

    @AfterEach
    void clear(){
        projectRepo.deleteAll();
        userRepo.deleteAll();
    }


    @Test
    void itShouldFindProjectByManagerID(){
        //Given

        User manager = User.builder()
                .firstName("Omar")
                .lastName("Khraim")
                .email("omarKhraim33@gmial.com")
                .password("12346").build();
        userRepo.save(manager);

        Project project = Project.builder()
                .description("Hello")
                .endDate(LocalDate.now())
                .name("Project Test")
                .manager(manager).build();

        projectRepo.save(project);


        //When
        boolean exists = projectRepo.existsByManager_Id(manager.getId());


        //Then

        assertThat(exists).isTrue();
    }

    @Test
    void itDoesNotHaveManager(){
        //Given

        Project project = Project.builder()
                .description("Hello")
                .endDate(LocalDate.now())
                .name("Project Test")
                .build();

        projectRepo.save(project);


        //When
        boolean exists = projectRepo.existsByManager_Id(1);


        //Then

        assertThat(exists).isFalse();
    }
}
