package com.skilldistillery.bmtk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Task;
import com.skilldistillery.bmtk.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public List<Task> findTasksByEmpUsername(String username){
		List<Task> tasks = taskRepo.findTaskByEmpUsername(username);
		
		
		
		return tasks;
	}

}
