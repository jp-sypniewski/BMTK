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
			employee = empRepo.saveAndFlush(employee);
		} else {
			employee = null;
		}
		
		return employee;
	}

	@Override
	public Optional<Employee> updateEmployee(int id, Employee employee) {
		if (empRepo.findById(id).isPresent()){
            Employee existingEmployee = empRepo.findById(id).get();
            existingEmployee.setComp(employee.getComp());
            existingEmployee.setUserDetail(employee.getUserDetail());
            empRepo.save(existingEmployee);
            return empRepo.findById(id);
        }else{
            return null;
        }
	}

	@Override
	public Boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
