package com.skilldistillery.bmtk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
