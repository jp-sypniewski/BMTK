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

import com.skilldistillery.bmtk.entities.Company;
import com.skilldistillery.bmtk.services.CompanyService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class CompanyController {
	
	@Autowired
	private CompanyService CompanySvc;

	@GetMapping(value = "company")
	public List<Company> listCompany() {
	return  CompanySvc.listAllCompany();
	}
	
	@GetMapping(value = "company/{id}")
	public Optional<Company> listCompanyById(Integer id) {
	return  CompanySvc.listCompanyById(id);
	}
	
	@PostMapping(value = "createCompany")
	public Company createCompany(@RequestBody Company company){
	return CompanySvc.createCompany(company);
	}
	
	@PutMapping(value = "updateCompany/{id}")
	public Optional<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company){
	return CompanySvc.updateCompany(id, company);
	}
	
	@DeleteMapping(value = "deleteCompany/{id}")
	public Boolean deleteCompany(@PathVariable("id") int id) {
		return CompanySvc.deleteCompany(id).booleanValue();
	}

}
