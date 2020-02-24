package com.skilldistillery.bmtk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.bmtk.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	  
	  @Query(value="SELECT * FROM company JOIN owner on company.id = owner.company_id "
	  		+ "JOIN user_detail on owner.user_detail_id = user_detail.id "
	  		+ "JOIN user on user_detail.id = user.user_detail_id "
	  		+ "WHERE user.username = :username",
		    nativeQuery=true)
	  List<Company> findCompaniesByOwnerUsername(@Param("username") String username);


}
