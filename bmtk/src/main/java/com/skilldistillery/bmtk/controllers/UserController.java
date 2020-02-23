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
	private UserService UserSvc;
	
	@GetMapping(value = "ping")
	public String pingPong() {
		return "pong";
	}
	
	@GetMapping(value = "user")
	public List<User> listUser() {
	return  UserSvc.listAllUser();
	}
	
	@PostMapping(value = "createUser")
	public User createUser(@RequestBody User user){
	return UserSvc.createUser(user);
	}
	
	@PutMapping(value = "updateUser/{id}")
	public Optional<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
	return UserSvc.updateUser(id, user);
	}
	
	@DeleteMapping(value = "deleteUser/{id}")
	public Boolean deleteUser(@PathVariable("id") int id) {
		return UserSvc.deleteUser(id).booleanValue();
	}

}
