package com.example.TaskManager.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private long Id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private long manager_id;

}
