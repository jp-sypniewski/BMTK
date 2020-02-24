package com.skilldistillery.bmtk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bmtk.entities.User;
import com.skilldistillery.bmtk.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	
	@GetMapping(value = "user")
	public List<User> listUser() {
		return  userSvc.listAllUser();
	}
	
	@PostMapping(value = "user")
	public User createUser(@RequestBody User user){
		user = userSvc.createUser(user);
		
		
		
		
		return user;
	}
	
	@PutMapping(value = "user/{id}")
	public Optional<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		return userSvc.updateUser(id, user);
	}
	
	@DeleteMapping(value = "user/{id}")
	public Boolean deleteUser(@PathVariable("id") int id) {
		return userSvc.deleteUser(id).booleanValue();
	}

}
