package com.example.TaskManager.Service.Impl;

import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Entity.Users;
import com.example.TaskManager.Repository.ProjectRepository;
import com.example.TaskManager.Repository.UserRepository;
import com.example.TaskManager.Service.UserService;
import com.example.TaskManager.Util.ListMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    private UserRepository userRepo;
    @Mock
    private ListMapper listMapper;
    @Mock
    private ProjectRepository projRepo;
    @Mock
    private ModelMapper modelMapper;
    //    @InjectMocks
    private UserServiceImp userService;

    @BeforeEach
    void setUp() {
        // this line will make sure that any object with a Mock or MockInject
        // are properly set up and ready for testing
//        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserServiceImp(userRepo);
        userService.setListMapper(listMapper);
        userService.setProjRepo(projRepo);
        userService.setModelMapper(modelMapper);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        // this is just to make sure to clear all the objects used by Mockito
//        autoCloseable.close();
//    }

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

    @Test
    @Disabled
        // this annotation tells the program to ignore this test
    void manageProjects() {
    }

    @Test
    void createNewUser(){
        Users user = Users.builder()
                .firstName("")
                .build();
    }

    @Test
    void getUserById() {

        //Given
        long userId = 1;
        UserDTO mock = UserDTO.builder()
                .Id(userId)
                .firstName("test")
                .lastname("test")
                .password("1255")
                .email("testforUNitTest")
                .status((byte) 1)
                .build();
        Users user = Users.builder()
                .Id(userId)
                .firstName("test")
                .lastName("test")
                .password("1255")
                .email("testforUNitTest")
                .status((byte) 1)
                .build();

        when(userRepo.findById(userId)).thenReturn(Optional.of(user));

        //When
        UserDTO returnedUser = userService.getUserById(userId);

        //
        assertThat(returnedUser).isEqualTo(mock);


    }


    @Test
    void findAllUsers(){
        
    }
}