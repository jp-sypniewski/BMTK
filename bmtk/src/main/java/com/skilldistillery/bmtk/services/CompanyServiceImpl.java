package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.entities.Customer;
import com.skilldistillery.bmtk.repositories.CompanyRepository;
import com.skilldistillery.bmtk.repositories.CustomerRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository compRepo;

	@Autowired
	private CustomerRepository custRepo;

	@Override
	public List<Company> listAllCompany() {
		// TODO Auto-generated method stub
		return compRepo.findAll();
	}

	@Override
	public List<Company> listMyCompanies(String username) {
		List<Company> myCompanies = compRepo.findCompaniesByOwnerUsername(username);

		return myCompanies;
	}
	
	@Override
	public Set<Customer> getMyCustomers(int id){
		Set<Customer> customers = custRepo.findCustomersByCompanyId(id);
		return customers;
	}

	@Override
	public Optional<Company> listCompanyById(int id) {
		// TODO Auto-generated method stub
		return compRepo.findById(id);
	}

	@Override
	public Company createCompany(Company company) {
		// TODO Auto-generated method stub
		return compRepo.save(company);
	}

	@Override
	public Optional<Company> updateCompany(int id, Company company) {
		if (compRepo.findById(id).isPresent()) {
			Company existingCompany = compRepo.findById(id).get();
			existingCompany.setName(company.getName());
			existingCompany.setPhone(company.getPhone());
			existingCompany.setAddress(company.getAddress());
			existingCompany.setCompanyUrl(company.getCompanyUrl());
			existingCompany.setDescription(company.getDescription());
			existingCompany.setType(company.getType());
			existingCompany.setEmployees(company.getEmployees());
			compRepo.save(existingCompany);
			return compRepo.findById(id);
		} else {
			return null;
		}
	}

	@Override
	public Boolean deleteCompany(int id) {
		if (compRepo.findById(id).isPresent()) {
			compRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
