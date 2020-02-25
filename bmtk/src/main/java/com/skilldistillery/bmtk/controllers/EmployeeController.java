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
import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.services.AuthService;
import com.skilldistillery.bmtk.services.EmployeeService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class EmployeeController {
	
	@Autowired
	private EmployeeService empSvc;
	
	@Autowired
	private AuthService authSvc;

	@GetMapping(value = "employee")
	public List<Employee> listEmployee() {
		return  empSvc.listAllEmployee();
	}
	
	@GetMapping(value = "employee/{id}")
	public Optional<Employee> listEmployeeById(Integer id) {
		return  empSvc.listEmployeeById(id);
	}
	
	@PostMapping(value = "companies/{cid}/employee")
	public Employee createEmployee(@PathVariable("cid") Integer cid,
			@RequestBody User user){
		user = authSvc.register(user);
		Employee employee = empSvc.createEmployee(cid, user);
		return employee;
	}
	
	@PutMapping(value = "employee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
		employee = empSvc.updateEmployee(id, employee);
		
		
		return employee;
	}
	
	@DeleteMapping(value = "employee/{id}")
	public Boolean deleteEmployee(@PathVariable("id") int id) {
		return empSvc.deleteEmployee(id).booleanValue();
	}
}
