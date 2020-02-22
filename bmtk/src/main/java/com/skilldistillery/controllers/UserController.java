package com.skilldistillery.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserController {
	
	@GetMapping("ping")
	public String pingPong() {
		return "pong";
	}

}
