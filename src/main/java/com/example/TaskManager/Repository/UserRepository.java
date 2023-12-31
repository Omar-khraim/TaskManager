package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUsersByEmail(String email);

}
