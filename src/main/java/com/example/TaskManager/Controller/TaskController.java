package com.example.TaskManager.Controller;

import com.example.TaskManager.Controller.DTO.TaskDTO;
import com.example.TaskManager.Entity.Task;
import com.example.TaskManager.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskService taskService;


    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    public TaskDTO getTaskById(@PathVariable long taskId){
        return taskService.findTaskById(taskId);
    }

    @GetMapping("/findall")
    public List<TaskDTO> getAllTasks(){
        return taskService.findAll();
    }

    @DeleteMapping("/{taskId}")
    public void deleteById(@PathVariable long taskId){
        taskService.deleteById(taskId);
    }

    @PostMapping
    public void createNew(@RequestBody Task task){
        taskService.createNew(task);
    }

    @PutMapping
    public void update(@RequestBody Task task){
        taskService.update(task);
    }
}
