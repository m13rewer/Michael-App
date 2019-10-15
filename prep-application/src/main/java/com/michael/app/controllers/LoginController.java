package com.michael.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.app.beans.Account;
import com.michael.app.services.AccountService;

@RestController
@RequestMapping(value="/login")
@CrossOrigin(origins="http://prep-front.us-east-1.elasticbeanstalk.com", allowCredentials="true")
public class LoginController {
	@Autowired
	private AccountService us;

	@RequestMapping(method=RequestMethod.GET)
	public Account goLogin(HttpSession session) {
		return (Account) session.getAttribute("loggedAccount");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Account login(@RequestParam("user") String username, 
			@RequestParam("pass") String password, HttpSession session) {
		Account u = us.login(username, password);
		System.out.println(username);
		System.out.println(password);
		
		if(u != null) {
			
			session.setAttribute("loggedAccount", u);
			return u;
		}
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
