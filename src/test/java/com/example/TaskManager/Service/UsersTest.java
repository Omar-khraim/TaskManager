package com.example.TaskManager.Service;

import com.example.TaskManager.Repository.UserRepository;
import com.example.TaskManager.Service.Impl.UserServiceImp;
import com.example.TaskManager.Util.ListMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class UsersTest {

    @Mock
    UserRepository userRepo;
    @Mock
    ModelMapper modelMapper;
    @Mock
    ListMapper listMapper;
//    @InjectMocks
    private UserServiceImp userService;
//    ListMapper<User>

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        userService = new UserServiceImp(userRepo);
        userService.setModelMapper(modelMapper);
        userService.setListMapper(listMapper);
    }

    @Test
    public void findUserById() {

        userService.getUserById(1);
        verify(userService).getUserById(1);
    }
    @Test
    void canGetAllUser() {

        //When
        userService.getAllUsers();

        //Then
        // so instead of creating a data in the database and making sure that it matches
        // and because we know for a fact that the repo si working fine, so we only want
        // to check that it did call teh right method so this will check that this method was called
        verify(userRepo).findAll();
    }

}


