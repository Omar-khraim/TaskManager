package com.example.TaskManager.Controller;

import com.example.TaskManager.Controller.DTO.TaskDTO;
import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Controller.DTO.UserSignUpDTO;
import com.example.TaskManager.Repository.ProjectRepository;
import com.example.TaskManager.Repository.TaskRepository;
import com.example.TaskManager.Service.TaskService;
import com.example.TaskManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void createNewUser(@RequestBody UserSignUpDTO user) {
        userService.createNewUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDTO user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteById(@PathVariable long userId) {
        if (userService.deleteUserById(userId)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Operation Succeeded");
        }else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User actively manages Projects");
        }


    }

    @GetMapping("/{userId}/tasks")
    public List<TaskDTO> getUserTasks(@PathVariable long userId){
        return taskService.fndUserTasks(userId);
    }
}
