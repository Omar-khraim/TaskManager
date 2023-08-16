package com.example.TaskManager.Service;


import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Controller.DTO.UserSignUpDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(long userId);

    List<UserDTO> getAllUsers();

    void updateUser(UserDTO user);

    void deleteUserById(long userId);

    void createNewUser(UserSignUpDTO user);

    boolean manageProjects(long userId);



}
