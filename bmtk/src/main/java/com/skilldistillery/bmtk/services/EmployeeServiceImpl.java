package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Employee;
import com.skilldistillery.bmtk.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository EmployeeRepo;

	@Override
	public List<Employee> listAllEmployee() {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAll();
	}

	@Override
	public Optional<Employee> listEmployeeById(int id) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findById(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return EmployeeRepo.save(employee);
	}

	@Override
	public Optional<Employee> updateEmployee(int id, Employee employee) {
		if (EmployeeRepo.findById(id).isPresent()){
            Employee existingEmployee = EmployeeRepo.findById(id).get();
            existingEmployee.setComp(employee.getComp());
            existingEmployee.setuDetail(employee.getuDetail());
            EmployeeRepo.save(existingEmployee);
            return EmployeeRepo.findById(id);
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
