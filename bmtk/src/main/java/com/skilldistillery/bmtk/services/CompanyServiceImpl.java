package com.skilldistillery.bmtk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.entities.Customer;
import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.entities.UserDetail;
import com.skilldistillery.bmtk.repositories.CompanyRepository;
import com.skilldistillery.bmtk.repositories.CustomerRepository;
import com.skilldistillery.bmtk.repositories.UserRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository compRepo;

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private UserRepository userRepo;

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
	public Company listCompanyById(int id) {
		// TODO Auto-generated method stub
		Company company = null;
		
		Optional<Company> optComp = compRepo.findById(id);
		if (optComp.isPresent()) {
			company = optComp.get();
		}
		return company;
	}

	@Override
	public Company createCompany(Company company, String username) {
		List<User> users = userRepo.findByUsername(username);
		User user = null;
		if (users.size() > 0) {
			user = users.get(0);
			UserDetail ud = user.getUserDetail();
			List<UserDetail> ownerList = new ArrayList<>();
			ownerList.add(ud);
			company.setOwners(ownerList);
			company.setActive(true);
			company = compRepo.saveAndFlush(company);
		} else {
			company = null;
		}
		
		return company;
	}

	@Override
	public Company updateCompany(int id, Company company) {
		Optional<Company> optComp = compRepo.findById(id);

		if (optComp.isPresent()) {
			Company managedComp = optComp.get();
			if (company.getName() != null) {
				managedComp.setName(company.getName());
			}
			if (company.getType() != null) {
				managedComp.setType(company.getType());
			}
			if (company.getAddress() != null) {
				managedComp.setAddress(company.getAddress());
			}
			if (company.getCity() != null) {
				managedComp.setCity(company.getCity());
			}
			if (company.getState() != null) {
				managedComp.setState(company.getState());
			}
			if (company.getZip() != null) {
				managedComp.setZip(company.getZip());
			}
			if (company.getPhone() != null) {
				managedComp.setPhone(company.getPhone());
			}
			if (company.getDescription() != null) {
				managedComp.setDescription(company.getDescription());
			}
			if (company.getCompanyUrl() != null) {
				managedComp.setCompanyUrl(company.getCompanyUrl());
			}
			if (company.getActive() != null) {
				managedComp.setActive(company.getActive());
			}
			
			company = compRepo.saveAndFlush(managedComp);
					
		} else {
			company = null;
		}
		return company;
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
	
	@Override
	public Boolean isCompanyOwner(int id, String username) {
		Boolean isOwner = false;
		Optional<Company> compopt = compRepo.findById(id);
		if (compopt.isPresent()) {
			Company company = compopt.get();
			for (UserDetail owner : company.getOwners()) {
				if (owner.getUser().getUsername().equals(username)) {					
					isOwner = true;
					break;
				}
			}
		}
		
		return isOwner;
	}

}
