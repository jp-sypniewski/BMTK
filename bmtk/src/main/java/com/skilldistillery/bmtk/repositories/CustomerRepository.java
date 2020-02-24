package com.skilldistillery.bmtk.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.bmtk.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "SELECT DISTINCT * FROM customer JOIN project on customer.id = project.customer_id "
			+ "WHERE project.company_id = :id", nativeQuery = true)
	Set<Customer> findCustomersByCompanyId(@Param("id") int id);

}
