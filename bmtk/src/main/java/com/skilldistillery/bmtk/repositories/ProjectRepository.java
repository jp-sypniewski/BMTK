package com.skilldistillery.bmtk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	List<Project> findByCust_UDetail_Id(Integer id);

}
