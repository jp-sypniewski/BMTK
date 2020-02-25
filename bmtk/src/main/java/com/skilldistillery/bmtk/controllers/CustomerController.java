package com.skilldistillery.bmtk.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bmtk.entities.Customer;
import com.skilldistillery.bmtk.services.CustomerService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class CustomerController {
	
	@Autowired
	private CustomerService custSvc;
	
	@PutMapping(value = "customers/{cid}")
	public Customer updateCompany(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("cid") Integer cid, @RequestBody Customer customer) {
		try {
			customer = custSvc.updateCustomer(cid, customer);
			if (customer == null) {
				res.setStatus(404);
				return customer;
			}
			res.setStatus(200);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
	}

}
