package com.skilldistillery.bmtk.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bmtk.entities.Project;
import com.skilldistillery.bmtk.services.ProjectService;
import com.skilldistillery.bmtk.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class ProjectController {
	
	@Autowired
	private ProjectService projSvc;
		
	@GetMapping(path="projects")
	public List<Project> getProjectsByCustomer(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal){
		List<Project> projects = projSvc.getProjectsForCustomer(principal.getName());
		return projects;
	}

	@GetMapping(path="companies/{cid}/projects")
	public List<Project> getProjectsByCompany(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("cid") Integer cid){
		List<Project> projects = projSvc.getProjectsByCompany(cid);
		
		
		
		return projects;
	}
}
