package com.example.TaskManager.Service;

import com.example.TaskManager.Controller.DTO.ProjectDTO;
import com.example.TaskManager.Entity.Project;

import java.util.List;

public interface ProjectService {

    ProjectDTO findProjectById(long projectId);
    List<ProjectDTO> findAllProjects();
    void deleteProjectById(long projectId);
    void createProject(Project project);
    void updateProject(Project project);
}
