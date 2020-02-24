package com.skilldistillery.bmtk.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bmtk.entities.Task;
import com.skilldistillery.bmtk.services.TaskService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class TaskController {
	
	@Autowired
	private TaskService taskSvc;
	
	@GetMapping("tasks")
	public List<Task> getTasksByEmployee(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal){
		List<Task> tasks = taskSvc.findTasksByEmpUsername(principal.getName());
		
		
		return tasks;
	}

}