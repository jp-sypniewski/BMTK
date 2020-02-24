package com.skilldistillery.bmtk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.repositories.UserRepository;

public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {
		String encodedPW = encoder.encode(user.getPassword());
		user.setPassword(encodedPW); // only persist encoded password

		// set other fields to default values
		user.setActive(true);
		

		userRepo.saveAndFlush(user);
		return user;
	}

}
