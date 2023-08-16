package com.example.TaskManager.Controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpDTO {
    private String firstName;
    private String lastname;
    private String password;
    private String email;
    private byte status;
}
