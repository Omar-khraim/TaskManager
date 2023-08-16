package com.example.TaskManager.Repository;

import com.example.TaskManager.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByManager_Id(long userId);
}
