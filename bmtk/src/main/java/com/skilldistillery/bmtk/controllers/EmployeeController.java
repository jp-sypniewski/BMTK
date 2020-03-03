package com.skilldistillery.bmtk.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public Employee createEmployee(HttpServletRequest req,
			HttpServletResponse res,
			@PathVariable("cid") Integer cid,
			@RequestBody User user){
		try {
			Employee employee = empSvc.createEmployee(cid, user);
			if (employee == null) {
				res.setStatus(404);
				return employee;
			}
			res.setStatus(201);
			return employee;
		} catch (Exception e) {
			res.setStatus(400);
			return null;
		}
	}
	
	@PutMapping(value = "employee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
		employee = empSvc.updateEmployee(id, employee);
		
		
		return employee;
	}
	
	@DeleteMapping(value = "employee/{id}")
	public void deleteEmployee(HttpServletRequest req,
			HttpServletResponse res,
			@PathVariable("id") int id) {
		try {
			boolean deleted = empSvc.deleteEmployee(id);
			if (deleted) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
}
