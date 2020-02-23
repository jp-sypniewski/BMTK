package com.skilldistillery.bmtk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {


}
