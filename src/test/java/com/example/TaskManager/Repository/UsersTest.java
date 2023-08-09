package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Users;
import com.example.TaskManager.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@DataJpaTest
public class UsersTest {


    @Autowired
    UserRepository userRepo;

    @Test
    public void testCreate(){
        Users user = Users.builder().firstName("Omar").lastName("Khraim").email("omarKhraim@gmial.com").password("12346").build();
        userRepo.save(user);
        assertNotNull(user);
    }

}
