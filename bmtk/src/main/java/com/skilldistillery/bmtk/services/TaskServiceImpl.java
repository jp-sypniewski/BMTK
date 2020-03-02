package com.skilldistillery.bmtk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Employee;
import com.skilldistillery.bmtk.entities.Project;
import com.skilldistillery.bmtk.entities.Task;
import com.skilldistillery.bmtk.repositories.EmployeeRepository;
import com.skilldistillery.bmtk.repositories.ProjectRepository;
import com.skilldistillery.bmtk.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProjectRepository projRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
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
			task.setActive(true);
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
				if (task.getName() != null) {
					managedTask.setName(task.getName());
				}
				if (task.getDescription() != null) {
					managedTask.setDescription(task.getDescription());
				}
				if (task.getDueDate() != null) {
					managedTask.setDueDate(task.getDueDate());
				}
				if (task.isPaid() != null) {
					managedTask.setPaid(task.isPaid());
				}
				if (task.isTemplate() != null) {
					managedTask.setTemplate(task.isTemplate());
				}
				if (task.getStartDate() != null) {
					managedTask.setStartDate(task.getStartDate());
				}
				if (task.getCompleteDate() != null) {
					managedTask.setCompleteDate(task.getCompleteDate());
				}
				if (task.getStatus() != null) {
					managedTask.setStatus(task.getStatus());
				}
				if (task.getType() != null) {
					managedTask.setType(task.getType());
				}
				if (task.getPriority() != null) {
					managedTask.setPriority(task.getPriority());
				}
				if (task.getPaymentDetail() != null) {
					managedTask.setPaymentDetail(task.getPaymentDetail());
				}
				if (task.getPrice() != null) {
					managedTask.setPrice(task.getPrice());
				}
				if (task.getActive() != null) {
					managedTask.setActive(task.getActive());
				}
				if (task.getEmployees().size() != 0) {
					managedTask.setEmployees(task.getEmployees());
				}
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
