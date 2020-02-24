package com.skilldistillery.bmtk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Project;
import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.repositories.ProjectRepository;
import com.skilldistillery.bmtk.repositories.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Project> getProjectsForCustomer(String username){
		User user = userRepo.findByUsername(username).get(0);
		Integer id = user.getUserDetail().getId();
		
		List<Project> projects = projRepo.findByCustomer_UserDetail_Id(id);
		
		
		
		
		return projects;
	}

}
