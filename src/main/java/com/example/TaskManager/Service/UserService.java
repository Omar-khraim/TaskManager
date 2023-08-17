package com.example.TaskManager.Service;


import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Controller.DTO.UserSignUpDTO;
import com.example.TaskManager.Entity.Task;

import java.util.List;

public interface UserService {

    UserDTO getUserById(long userId);

    List<UserDTO> getAllUsers();

    void updateUser(UserDTO user);

    boolean deleteUserById(long userId);

    void createNewUser(UserSignUpDTO user);

    boolean manageProjects(long userId);



}
