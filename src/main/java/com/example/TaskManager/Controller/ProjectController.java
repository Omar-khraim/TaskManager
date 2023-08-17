package com.example.TaskManager.Controller;


import com.example.TaskManager.Controller.DTO.ProjectDTO;
import com.example.TaskManager.Entity.Project;
import com.example.TaskManager.Service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ProjectDTO getProjectById(@PathVariable long projectId){
        return projectService.findProjectById(projectId);
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects(){
        return projectService.findAllProjects();
    }

    @PostMapping
    public void createProject(@RequestBody Project project){
        projectService.createProject(project);
    }

    @PutMapping
    public void updateProject(@RequestBody Project project){
        projectService.createProject(project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteById(@PathVariable long projectId){
        projectService.deleteProjectById(projectId);
    }


}
