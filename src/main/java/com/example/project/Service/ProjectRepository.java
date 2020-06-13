package com.example.project.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface ProjectRepository extends JpaRepository<ProjectTable, Long>
{
	ProjectTable findByUsername(String username); 
}
