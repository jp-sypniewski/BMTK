package com.skilldistillery.bmtk.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.skilldistillery.bmtk.entities.UserDetail;
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
	public User updateUser(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("id") int id,
			@RequestBody User user){
		try {
			user = userSvc.updateUser(id, user);
			if (user== null) {
				res.setStatus(404);
				return user;
			}
			res.setStatus(200);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
		
	}
	
	
	
	
	
	
	@DeleteMapping(value = "user/{id}")
	public Boolean deleteUser(@PathVariable("id") int id) {
		return userSvc.deleteUser(id).booleanValue();
	}

}
