package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Project;
import com.skilldistillery.bmtk.entities.Task;
import com.skilldistillery.bmtk.repositories.ProjectRepository;
import com.skilldistillery.bmtk.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProjectRepository projRepo;
	
	@Override
	public List<Task> findTasksByEmpUsername(String username){
		List<Task> tasks = taskRepo.findTaskByEmpUsername(username);
		return tasks;
	}
	
	@Override
	public Task addTaskToProject(int id, Task task) {
		Optional<Project> optproj = projRepo.findById(id);
		if (optproj.isPresent()) {
			Project project = optproj.get();
			task.setProject(project);
			task.setPaid(false);
			task.setTemplate(false);
			task.setPrice(0.0);
			task = taskRepo.saveAndFlush(task);
		} else {
			task = null;
		}
		return task;
	}

	@Override
	public Task updateTask(int pid, int tid, Task task) {
		Optional<Project> optproj = projRepo.findById(pid);
		Optional<Task> opttask = taskRepo.findById(tid);
		if (optproj.isPresent()) {
			if (opttask.isPresent()) {
				Task managedTask = opttask.get();
				managedTask.setName(task.getName());
				managedTask.setDescription(task.getDescription());
				managedTask.setDueDate(task.getDueDate());
				managedTask.setPaid(task.isPaid());
				managedTask.setTemplate(task.isTemplate());
				managedTask.setStartDate(task.getStartDate());
				managedTask.setCompleteDate(task.getCompleteDate());
				managedTask.setStatus(task.getStatus());
				managedTask.setType(task.getType());
				managedTask.setPriority(task.getPriority());
				managedTask.setPaymentDetail(task.getPaymentDetail());
				managedTask.setPrice(task.getPrice());
				task = taskRepo.saveAndFlush(managedTask);
			} else {
				task = null;
			}
		} else {
			task = null;
		}
		return task;
	}
	
}
