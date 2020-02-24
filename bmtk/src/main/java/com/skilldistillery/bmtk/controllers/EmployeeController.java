package com.skilldistillery.bmtk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bmtk.entities.Employee;
import com.skilldistillery.bmtk.services.EmployeeService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class EmployeeController {
	
	@Autowired
	private EmployeeService EmployeeSvc;

	@GetMapping(value = "employee")
	public List<Employee> listEmployee() {
	return  EmployeeSvc.listAllEmployee();
	}
	
	@GetMapping(value = "employee/{id}")
	public Optional<Employee> listEmployeeById(Integer id) {
	return  EmployeeSvc.listEmployeeById(id);
	}
	
	@PostMapping(value = "createEmployee")
	public Employee createEmployee(@RequestBody Employee employee){
	return EmployeeSvc.createEmployee(employee);
	}
	
	@PutMapping(value = "updateEmployee/{id}")
	public Optional<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
	return EmployeeSvc.updateEmployee(id, employee);
	}
	
	@DeleteMapping(value = "deleteEmployee/{id}")
	public Boolean deleteEmployee(@PathVariable("id") int id) {
		return EmployeeSvc.deleteEmployee(id).booleanValue();
	}
}
