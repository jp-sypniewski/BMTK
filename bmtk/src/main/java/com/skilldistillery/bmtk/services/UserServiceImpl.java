package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.entities.UserDetail;
import com.skilldistillery.bmtk.repositories.UserDetailRepository;
import com.skilldistillery.bmtk.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserDetailRepository udRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> listUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User createUser(User user) {
		
		List<User> users = userRepo.findByUsername(user.getUsername());
		if (users.size() > 0) {
			user = null;
		} else {
			UserDetail ud = user.getUserDetail();
			ud = udRepo.saveAndFlush(ud);
			user.setUserDetail(ud);
			user = userRepo.saveAndFlush(user);
		}
		
		return user;
	}
	
	

	@Override
	public User updateUser(int id, User user) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isPresent()) {
			User managedUser = optUser.get();
			if (user.getUsername() != null) {
				managedUser.setUsername(user.getUsername());
			}
			if (user.getPassword() != null) {
				String encodedPW = encoder.encode(user.getPassword());
				managedUser.setPassword(encodedPW);
			}
			if (user.getActive() != null ) {
				managedUser.setActive(user.getActive());
			}
			user = userRepo.saveAndFlush(managedUser);
		} else {
			user = null;
		}
		return user;
	}

	@Override
	public Boolean deleteUser(int id) {
		 if (userRepo.findById(id).isPresent()){
			 userRepo.deleteById(id);
			 return true;
		 }
		 else {return false;}
		 }

	

}
