package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.entities.UserDetail;

public interface UserService {
	
	List<User> listAllUser();
	
	Optional<User> listUserById(int id);
	
	public User createUser(User user);
	
	public User updateUser(int id, User user);
	
	public Boolean deleteUser(int id);

	UserDetail updateUserDetail(int id, UserDetail ud);

	User getUserByPrincipal(String username);

	Set<User> findByEmail(String searchTerm);

}
