package com.example.TaskManager.Service;

import com.example.TaskManager.Controller.DTO.TaskDTO;
import com.example.TaskManager.Entity.Task;

import java.util.List;

public interface TaskService {

    TaskDTO findTaskById(long taskId);
    List<TaskDTO> findAll();
    void deleteById(long taskId);
    void createNew(Task task);
    void update(Task task);

}
