package com.example.TaskManager.Service.Impl;


import com.example.TaskManager.Controller.DTO.UserDTO;
import com.example.TaskManager.Entity.Users;
import com.example.TaskManager.Repository.UserRepository;
import com.example.TaskManager.Service.UserService;
import com.example.TaskManager.Util.ListMapper;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceEmp implements UserService {


    ////// Bean Initialization /////
    private  ModelMapper modelMapper;
    private ListMapper listMapper;
    private final UserRepository userRepo;


    ////// Bean Injections ////////
    public UserServiceEmp(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Autowired
    public void  setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setListMapper(ListMapper<Users, UserDTO> listMapper){
        this.listMapper = listMapper;
    }


    ////// Methods //////

    @Override
    public UserDTO getUserById(long userId) {
        return modelMapper.map(userRepo.findById(userId), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return listMapper.MapList(UserDTO.class,userRepo.findAll());
    }

    @Override
    public void updateUser(UserDTO user) {
        userRepo.save(modelMapper.map(user, Users.class));
    }

    @Override
    public void deleteUserById(long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public void createNewUser(UserDTO user) {
        userRepo.save(modelMapper.map(user , Users.class));
    }
}
