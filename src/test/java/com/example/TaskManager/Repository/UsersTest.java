package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Users;
import com.example.TaskManager.Repository.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class UsersTest {


    @Autowired
    UserRepository userRepo;

    @AfterEach
    void clear(){
        userRepo.deleteAll();
    }

    @Test
    public void itHasUserThatExistsByEmail() {
        //Given
        Users user = Users.builder()
                .firstName("Omar")
                .lastName("Khraim")
                .email("omarKhraim@gmial.com")
                .password("12346").build();
        userRepo.save(user);

        // When
        Users fetchedUser = userRepo.findUsersByEmail(user.getEmail());

        // Then
        assertThat(fetchedUser).isNotNull();
    }

    @Test
    public void noUserExistsByEmail() {
        //Given
       String email = "OmarKhraim33@gmail.com";

        // When
        Users fetchedUser = userRepo.findUsersByEmail(email);

        // Then
        assertThat(fetchedUser).isNull();
    }

}
