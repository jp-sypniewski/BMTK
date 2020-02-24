package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository CompanyRepo;

	@Override
	public List<Company> listAllCompany() {
		// TODO Auto-generated method stub
		return CompanyRepo.findAll();
	}
	
	public List<Company> listMyCompanies(String username){
		List<Company> myCompanies = null;
		
		
		
		return myCompanies;
	}

	@Override
	public Optional<Company> listCompanyById(int id) {
		// TODO Auto-generated method stub
		return CompanyRepo.findById(id);
	}

	@Override
	public Company createCompany(Company company) {
		// TODO Auto-generated method stub
		return CompanyRepo.save(company);
	}

	@Override
	public Optional<Company> updateCompany(int id, Company company) {
		if (CompanyRepo.findById(id).isPresent()){
            Company existingCompany = CompanyRepo.findById(id).get();
            existingCompany.setName(company.getName());
            existingCompany.setPhone(company.getPhone());
            existingCompany.setAddress(company.getAddress());
            existingCompany.setCompanyUrl(company.getCompanyUrl());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setType(company.getType());
            existingCompany.setEmployees(company.getEmployees());
            CompanyRepo.save(existingCompany);
            return CompanyRepo.findById(id);
        }else{
            return null;
        }
	}

	@Override
	public Boolean deleteCompany(int id) {
		if (CompanyRepo.findById(id).isPresent()){
			 CompanyRepo.deleteById(id);
			 return true;
		 }
		 else {return false;}
	}

}
