package com.example.TaskManager.Service;

import com.example.TaskManager.Repository.UserRepository;
import com.example.TaskManager.Service.Impl.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UsersTest {

    @Mock
    UserRepository userRepo;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    UserServiceImp userService;
//    ListMapper<User>

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        userService.setModelMapper(modelMapper);
    }

    @Test
    public void findUserById() {
    }

}


