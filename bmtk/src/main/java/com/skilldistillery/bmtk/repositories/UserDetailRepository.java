package com.skilldistillery.bmtk.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bmtk.entities.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

	
}
