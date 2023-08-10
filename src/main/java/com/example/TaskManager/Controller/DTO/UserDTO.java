package com.example.TaskManager.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    long Id;
    String firstName;
    String lastname;
    String password;
    String email;
    LocalDateTime created;
    LocalDateTime updated;

}
