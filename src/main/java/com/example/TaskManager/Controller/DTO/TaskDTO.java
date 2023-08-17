package com.example.TaskManager.Controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private long Id;
    private String name;
    private String description;
    private Date dueDate;
    private short estimationTime;
    private UserDTO assignedTo;
    private ProjectDTO project;

}
