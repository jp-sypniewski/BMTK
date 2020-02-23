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
		return UserRepo.findById(id);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return UserRepo.save(user);
	}

	@Override
	public Optional<User> updateUser(int id, User user) {
		if (UserRepo.findById(id).isPresent()){
            User existingUser = UserRepo.findById(id).get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setUpdatedAt(user.getUpdatedAt());
            existingUser.setCreatedAt(user.getCreatedAt());
            existingUser.setActive(user.getActive());
            UserRepo.save(existingUser);
            return UserRepo.findById(id);
        }else{
            return null;
        }
	}

	@Override
	public Boolean deleteUser(int id) {
		 if (UserRepo.findById(id).isPresent()){
			 UserRepo.deleteById(id);
			 return true;
		 }
		 else {return false;}
		 }

	

}
