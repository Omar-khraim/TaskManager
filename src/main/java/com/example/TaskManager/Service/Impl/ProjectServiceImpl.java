package com.example.TaskManager.Service.Impl;

import com.example.TaskManager.Controller.DTO.ProjectDTO;
import com.example.TaskManager.Entity.Project;
import com.example.TaskManager.Repository.ProjectRepository;
import com.example.TaskManager.Service.ProjectService;
import com.example.TaskManager.Util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {


    ////// Bean Initialization /////
    private ModelMapper modelMapper;
    private ListMapper listMapper;
    private final ProjectRepository projectRepo;

    public ProjectServiceImpl(ProjectRepository projectRepo){
        this.projectRepo = projectRepo;
    }

    ////// Bean Injections ////////
    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setListMapper(ListMapper listMapper){
        this.listMapper = listMapper;
    }


    ////// Methods //////

    @Override
    public ProjectDTO findProjectById(long projectId) {
        return modelMapper.map(projectRepo.findById(projectId) , ProjectDTO.class);
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        return listMapper.mapList(projectRepo.findAll(),new ProjectDTO());
    }

    @Override
    public void deleteProjectById(long projectId) {
        projectRepo.deleteById(projectId);
    }

    @Override
    public void createProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public void updateProject(Project project) {
        projectRepo.save(project);
    }
}
