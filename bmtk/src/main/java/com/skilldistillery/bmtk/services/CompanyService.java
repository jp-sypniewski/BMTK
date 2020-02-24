package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.entities.Customer;
import com.skilldistillery.bmtk.entities.Employee;

public interface CompanyService {
	
List<Company> listAllCompany();
	
Optional<Company> listCompanyById(int id);
	
public Company createCompany(Company company);
	
public Optional<Company> updateCompany(int id, Company company);
	
public Boolean deleteCompany(int id);

List<Company> listMyCompanies(String username);

Set<Customer> getMyCustomers(int id);

}
