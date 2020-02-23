package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository UserRepo;

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return UserRepo.findAll();
	}

	@Override
	public Optional<User> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return UserRepo.save(user);
	}

	@Override
	public Optional<User> update(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
