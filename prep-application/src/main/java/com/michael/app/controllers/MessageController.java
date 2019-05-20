package com.michael.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.app.beans.Fighter;

@RestController
@RequestMapping(value="/message")
//@CrossOrigin(origins="http://localhost:4200")
public class MessageController { //implements ApplicationContextAware{
	
	@Autowired
	public static ApplicationContext ac;
	@RequestMapping(method=RequestMethod.GET)
	public Fighter login(HttpSession session) {
	 
		Fighter example = ac.getBean(Fighter.class);
		example.setId(1);
		example.setName("Michael");
		//example.setTier("password");
		//example.setUsername("BrewerBitch");
				//new User(1, "m13rewer", "password", "Michael", "Brewer");
		return example;
	}
	
	/*
	 * @Override public void setApplicationContext(final ApplicationContext
	 * applicationContext) throws BeansException {
	 * System.out.println("setting context"); this.ac = applicationContext; }
	 */
	
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
