package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.bmtk.entities.User;

public interface UserService {
	
	List<User> listAllUser();
	
	Optional<User> listUserById(int id);
	
	public User createUser(User user);
	
	public User updateUser(int id, User user);
	
	public Boolean deleteUser(int id);

}
