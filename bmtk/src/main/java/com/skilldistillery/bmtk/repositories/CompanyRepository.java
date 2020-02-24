package com.skilldistillery.bmtk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
