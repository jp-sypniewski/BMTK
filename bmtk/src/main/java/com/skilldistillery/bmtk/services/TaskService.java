package com.skilldistillery.bmtk.services;

import java.util.List;

import com.skilldistillery.bmtk.entities.Task;

public interface TaskService {

	List<Task> findTasksByEmpUsername(String username);

}