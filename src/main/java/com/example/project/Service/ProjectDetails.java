package com.example.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProjectDetails implements UserDetailsService
{
	
	@Autowired
	ProjectRepository repo;
	
	public String username;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException 
	{
		ProjectTable user = repo.findByUsername(arg0);
		username = user.getUsername();
		return user;
	}

}
