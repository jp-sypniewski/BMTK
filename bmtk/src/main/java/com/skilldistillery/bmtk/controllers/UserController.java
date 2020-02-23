package com.skilldistillery.bmtk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("ping")
	public String pingPong() {
		return "pong";
	}
	
	@GetMapping("user")
	public List<User> listUser() {
	return  UserSvc.listAllUser();
	}

}
