package com.skilldistillery.bmtk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	List<Project> findByCustomer_UserDetail_Id(Integer id);
	
	List<Project> findByCompany_Id(Integer id);

}
