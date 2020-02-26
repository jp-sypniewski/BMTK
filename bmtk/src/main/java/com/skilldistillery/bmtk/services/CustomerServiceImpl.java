package com.skilldistillery.bmtk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.Customer;
import com.skilldistillery.bmtk.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public Customer updateCustomer(Integer cid, Customer customer) {
		Optional<Customer> optcust = custRepo.findById(cid);
		if (optcust.isPresent()) {
			Customer managedCust = optcust.get();
			if (customer.getActive() != null) {
				managedCust.setActive(customer.getActive());
			}
			if (customer.getPaymentMethod() != null) {
				managedCust.setPaymentMethod(customer.getPaymentMethod());
			}
			customer = custRepo.saveAndFlush(managedCust);
		} else {
			customer = null;
		}
		
		return customer;
	}

}
