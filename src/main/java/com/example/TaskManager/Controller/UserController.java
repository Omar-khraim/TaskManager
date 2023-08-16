package com.example.TaskManager.Controller;

import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Controller.DTO.UserSignUpDTO;
import com.example.TaskManager.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }
    @GetMapping("/findall")
    public  List<UserDTO> findAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void createNewUser(@RequestBody UserSignUpDTO user){
        userService.createNewUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDTO user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable long userId){
        userService.deleteUserById(userId);
    }
}
