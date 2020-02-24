package com.skilldistillery.bmtk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByUsername(String username);

}
