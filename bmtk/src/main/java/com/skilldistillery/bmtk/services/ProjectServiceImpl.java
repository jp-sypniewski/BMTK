package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.entities.Customer;
import com.skilldistillery.bmtk.entities.Project;
import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.entities.UserDetail;
import com.skilldistillery.bmtk.repositories.CompanyRepository;
import com.skilldistillery.bmtk.repositories.CustomerRepository;
import com.skilldistillery.bmtk.repositories.ProjectRepository;
import com.skilldistillery.bmtk.repositories.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CompanyRepository compRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public List<Project> getProjectsForCustomer(String username){
		
		List<User> users = userRepo.findByUsername(username);
		User user = null;
		List<Project> projects = null;
		
		if (users.size() > 0) {
			user = users.get(0);
			Integer id = user.getUserDetail().getId();
			projects = projRepo.findByCustomer_UserDetail_Id(id);
		}
		
		return projects;
	}
	
	@Override
	public List<Project> getProjectsByCompany(int id){
		List<Project> projects = projRepo.findByCompany_Id(id);
		return projects;
	}
	
	
	
	@Override
	public Project addProject(int id, Project project, String username) {
		List<User> users = userRepo.findByUsername(username);
		User user = null;
		if (users.size() > 0) {
			user = users.get(0);
			UserDetail ud = user.getUserDetail();
			Optional<Company> optCompany = compRepo.findById(id);
			if (optCompany.isPresent()) {
				Company company = optCompany.get();
				project.setCompany(company);
				project.setActive(true);
				
					if (ud.getCustomer() == null) {
						Customer customer = new Customer();
						customer.setUserDetail(ud);
						customer.setActive(true);
						customer = custRepo.saveAndFlush(customer);
						project.setCustomer(customer);
				
					} else {
						project.setCustomer(ud.getCustomer());
					}
				project = projRepo.saveAndFlush(project);
				
			} else {
				project = null;
			}
		} else {
			project = null;
		}
		
		return project;
	}
	
	
	
	
	
	@Override
	public Project updateProject(int cid, int pid, Project project) {
		Optional<Company> optComp = compRepo.findById(cid);
		Optional<Project> optProj = projRepo.findById(pid);
		if (optComp.isPresent()) {
			if (optProj.isPresent()) {
				Project managedProj = optProj.get();
				if (project.getName() != null) {
					managedProj.setName(project.getName());
				}
				if (project.getCompany() != null) {
					managedProj.setCompany(project.getCompany());
				}
				if (project.getCustomer() != null) {
					managedProj.setCustomer(project.getCustomer());
				}
				if (project.getActive() != null) {
					managedProj.setActive(project.getActive());
				}
				project = projRepo.saveAndFlush(managedProj);
			} else {
				project = null;
			} 
			}else {
				project = null;
		}
		
		return project;
		
	}

}
