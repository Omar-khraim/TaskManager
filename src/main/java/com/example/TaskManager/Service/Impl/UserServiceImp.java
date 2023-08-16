package com.example.TaskManager.Service.Impl;


import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Controller.DTO.UserSignUpDTO;
import com.example.TaskManager.Entity.Users;
import com.example.TaskManager.Repository.ProjectRepository;
import com.example.TaskManager.Repository.UserRepository;
import com.example.TaskManager.Service.UserService;
import com.example.TaskManager.Util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    ////// Bean Initialization /////
    private ModelMapper modelMapper;
    private ListMapper listMapper;

    //    private  PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private ProjectRepository projRepo;


    ////// Bean Injections ////////
    public UserServiceImp(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setListMapper(ListMapper listMapper) {
        this.listMapper = listMapper;
    }

    @Autowired
    public void setProjRepo(ProjectRepository projRepo) {
        this.projRepo = projRepo;
    }

//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
//        this.passwordEncoder = passwordEncoder;
//    }


    ////// Methods //////

    @Override
    public UserDTO getUserById(long userId) {
        return modelMapper.map(userRepo.findById(userId), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return listMapper.MapList(UserDTO.class, userRepo.findAll());
    }

    @Override
    public void updateUser(UserDTO user) {
        userRepo.save(modelMapper.map(user, Users.class));
    }

    @Override
    public void deleteUserById(long userId) {
        if (!manageProjects(userId))
            userRepo.deleteById(userId);

    }

    @Override
    public void createNewUser(UserSignUpDTO user) {
        userRepo.save(modelMapper.map(user, Users.class));
//
//        Users newUser = Users.builder()
//                .lastName(user.getFirstName())
//                .firstName(user.getLastname())
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .created(LocalDateTime.now())
//                .status((byte) 1)
//                .build();
//
//        userRepo.save(newUser);
    }

    @Override
    public boolean manageProjects(long userId) {
        return projRepo.existsByManager_Id(userId);
    }
}
