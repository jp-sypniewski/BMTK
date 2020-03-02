package com.skilldistillery.bmtk.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.bmtk.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByUsername(String username);
	
	Set<User> findByUserDetail_emailContaining(String searchTerm);
	
	@Query(value="SELECT DISTINCT * FROM user JOIN user_detail ON user.user_detail_id = user_detail.id "
			+ "WHERE user_detail.email like :email", nativeQuery = true)
	Set<User> findUsersByEmail(@Param("email") String searchTerm);
	
}
