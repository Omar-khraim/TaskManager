package com.example.TaskManager.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;
    private String description;
    private Date dueDate;
    private byte estimationTime;

    @OneToOne
    private Users user;

    @ManyToOne
    private Project project;
}
