package com.michael.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.app.beans.Account;
import com.michael.app.services.AccountService;
//import com.revature.beans.Item;
//import com.revature.services.AccountService;

@RestController
@RequestMapping(value="/register")
@CrossOrigin(origins="http://prep-front.us-east-1.elasticbeanstalk.com", allowCredentials="true")
public class RegistrationController {
	@Autowired 
	private AccountService as;
//	@RequestMapping(method=RequestMethod.GET)
//	public Account goLogin(HttpSession session) {
////		if(session.getAttribute("user")!=null)
////			return "redirect:home";
////		return "static/login.html";
//		//return (LoginInfo) session.getAttribute("loggedAdmin");
//		return (Account) session.getAttribute("loggedAccount");
//	}
//	
	@RequestMapping(method=RequestMethod.GET)
	public Account goLogin(HttpSession session) {
//		if(session.getAttribute("user")!=null)
//			return "redirect:home";
//		return "static/login.html";
		//return (LoginInfo) session.getAttribute("loggedAdmin");
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Account Register(
			@RequestParam("user") String username, @RequestParam("pass") String password, 
			@RequestParam("first") String firstname, 
			@RequestParam("last") String lastname, HttpSession session) {
		
		Account a = new Account(null, username, password, firstname, lastname);
		
		as.saveAccount(a);
		a = as.getAccount(a.getId());
		
		System.out.println(username);
		System.out.println(password);
		
		if(a != null) {
			//session.setAttribute("registeredAccount", a);
			return a;
		}
		
		//return null;
		return null;
	}
	
//	@RequestMapping(method=RequestMethod.DELETE)
//	public void logout(HttpSession session) {
//		session.invalidate();
//	}
}