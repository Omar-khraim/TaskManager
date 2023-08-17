package com.example.TaskManager.Service.Impl;

import com.example.TaskManager.Controller.DTO.TaskDTO;
import com.example.TaskManager.Entity.Task;
import com.example.TaskManager.Repository.TaskRepository;
import com.example.TaskManager.Service.TaskService;
import com.example.TaskManager.Util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepo;
    private ListMapper listMapper;
    private ModelMapper modelMapper;

    TaskServiceImpl(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper= modelMapper;
    }

    @Autowired
    public void setListMapper(ListMapper listMapper){
        this.listMapper = listMapper;
    }


    @Override
    public TaskDTO findTaskById(long taskId) {
        return modelMapper.map(taskRepo.findById(taskId), TaskDTO.class);
    }

    @Override
    public List<TaskDTO> findAll() {
        return listMapper.mapList( taskRepo.findAll(),new TaskDTO());
    }

    @Override
    public void deleteById(long taskId) {
        taskRepo.deleteById(taskId);
    }

    @Override
    public void createNew(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void update(Task task) {
        taskRepo.save(task);
    }

    @Override
    public List<TaskDTO> fndUserTasks(long userId) {
        return listMapper.mapList(taskRepo.findByUser_Id(userId), new TaskDTO());
//        return (List<TaskDTO>) modelMapper.map(taskRepo.findByUser_Id(userId),TaskDTO.class);
    }
}
