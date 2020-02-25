package com.skilldistillery.bmtk.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		System.out.println(principal);
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
	
	@PostMapping(path="companies/{cid}/projects")
	public Project makeNewProjectForCompany(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("cid") Integer cid,
			@RequestBody Project project) {
		if (principal != null) {
			project = projSvc.addProject(cid, project, principal.getName());
			res.setStatus(201);
			return project;
		} else {
			res.setStatus(401);
			return null;
		}
			
	}
	
	@PutMapping(path="companies/{cid}/projects/{pid}")
	public Project updateProject(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("cid") Integer cid,
			@PathVariable("pid") Integer pid,
			@RequestBody Project project) {
		try {
			project = projSvc.updateProject(cid, pid, project);
			if (project == null) {
				res.setStatus(404);
				return project;
			}
			res.setStatus(200);
			return project;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
		
	}
	
}
