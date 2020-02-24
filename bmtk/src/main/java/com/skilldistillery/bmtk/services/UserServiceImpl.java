package com.skilldistillery.bmtk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<User> updateUser(int id, User user) {
		if (userRepo.findById(id).isPresent()){
            User existingUser = userRepo.findById(id).get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setUpdatedAt(user.getUpdatedAt());
            existingUser.setCreatedAt(user.getCreatedAt());
            existingUser.setActive(user.getActive());
            userRepo.save(existingUser);
            return userRepo.findById(id);
        }else{
            return null;
        }
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
