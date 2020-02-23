package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.User;

public interface UserService {
	
	List<User> listAllUser();
	
	Optional<User> listById(int id);
	
	public User createUser(User user);
	
	public Optional<User> update(int id, User user);
	
	public Boolean delete(int id);

}
