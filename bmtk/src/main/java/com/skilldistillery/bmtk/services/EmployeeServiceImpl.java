package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.entities.Employee;
import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.entities.UserDetail;
import com.skilldistillery.bmtk.repositories.CompanyRepository;
import com.skilldistillery.bmtk.repositories.EmployeeRepository;
import com.skilldistillery.bmtk.repositories.UserDetailRepository;
import com.skilldistillery.bmtk.repositories.UserRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private CompanyRepository compRepo;
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private UserDetailRepository udRepo;

	@Override
	public List<Employee> listAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> listEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id);
	}

	@Override
	public Employee createEmployee(int id, User user) {
		Employee employee = new Employee();
		Optional<Company> optcomp = compRepo.findById(id);
		if (optcomp.isPresent()) {
			Company company = optcomp.get();
			employee.setComp(company);
			UserDetail ud = user.getUserDetail();
			employee.setUserDetail(ud);
			employee.setActive(true);
			employee = empRepo.saveAndFlush(employee);
		} else {
			employee = null;
		}
		
		return employee;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> optemp = empRepo.findById(id);
		if (optemp.isPresent()){
            Employee managedEmployee = optemp.get();
            if (employee.getComp() != null) {
            	managedEmployee.setComp(employee.getComp());
            }
            if (employee.getUserDetail() != null) {
            	managedEmployee.setUserDetail(employee.getUserDetail());
            }
            if (employee.getActive() != null) {
            	managedEmployee.setActive(employee.getActive());
            }
            employee = empRepo.saveAndFlush(managedEmployee);
            
            return employee;
            
            
        } else {
            return null;
        }
	}

	@Override
	public Boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
