package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.bmtk.entities.Employee;
import com.skilldistillery.bmtk.entities.User;

public interface EmployeeService {
	
List<Employee> listAllEmployee();
	
	Optional<Employee> listEmployeeById(int id);
	
	public Employee createEmployee(int id, User user);
	
	public Optional<Employee> updateEmployee(int id, Employee employee);
	
	public Boolean deleteEmployee(int id);

}
