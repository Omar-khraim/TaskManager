package com.example.TaskManager.Controller.DTO;

import com.example.TaskManager.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long Id;
    private String firstName;
    private String lastname;
    private String password;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;
    private byte status;
    private List<RoleDTO> roles;

}
