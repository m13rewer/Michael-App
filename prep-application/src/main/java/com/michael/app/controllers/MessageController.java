package com.michael.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.app.beans.User;

@RestController
@RequestMapping(value="/message")
//@CrossOrigin(origins="http://localhost:4200")
public class MessageController {
//	@Autowired
//	private CustomerService cs;
//	@Autowired
//	private EmployeeService es;
	
	@RequestMapping(method=RequestMethod.GET)
	public User login(HttpSession session) {
		User example = new User(1, "m13rewer", "password", "Michael", "Brewer");
		return example;
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public LoginInfo login(@RequestParam("user") String username, 
//			@RequestParam("pass") String password, HttpSession session) {
//		Customer c = cs.getCustomer(username,  password);
//		Employee e = es.getEmployee(username, password);
//		if(e==null && c==null) {
//			return null;
//		}
//		LoginInfo loggedUser = new LoginInfo(c, e);
//		session.setAttribute("loggedUser", loggedUser);
//		return loggedUser;
//	}

}
