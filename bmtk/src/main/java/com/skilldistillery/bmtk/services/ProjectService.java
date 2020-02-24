package com.skilldistillery.bmtk.services;

import java.util.List;

import com.skilldistillery.bmtk.entities.Project;

public interface ProjectService {

	List<Project> getProjectsForCustomer(String username);

	List<Project> getProjectsByCompany(int id);

	Project addProject(int id, Project project, String username);

}
