package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ust.dao.LoginDaoImpl;
import com.ust.model.Login;


@RestController

public class LoginController {
	
	@Autowired
	LoginDaoImpl ldao;
	
	///Role checker
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	
	public Login getRole(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		System.out.println("HELLO");
		System.out.println(password);
		return ldao.RoleChecker(username, password);
	}
}

