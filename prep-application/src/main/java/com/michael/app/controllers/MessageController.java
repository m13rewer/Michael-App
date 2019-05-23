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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.michael.app.beans.Fighter;
import com.michael.app.services.FighterService;
import com.michael.app.services.OriginService;
import com.michael.app.services.TierService;

@RestController
@RequestMapping(value="/message")
//@CrossOrigin(origins="http://localhost:4200")
public class MessageController implements ApplicationContextAware{
	
	@Autowired
	protected static ApplicationContext ac;
	@Autowired
	private FighterService fs;
	@Autowired
	private OriginService os;
	@Autowired
	private TierService ts;
	
	@RequestMapping(method=RequestMethod.GET)
	
	public Fighter login(HttpSession session) {
	 
		Fighter example = ac.getBean(Fighter.class);
		example.setId(1);
		example.setName("Michael");
		
		return example;
	}
	
	 @Override 
	 public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		 System.out.println("setting context"); 
		 this.ac = applicationContext; 
	 }
	 
	
	@RequestMapping(method=RequestMethod.POST)
	public void makeFighter(@RequestParam("name") String name, 
			@RequestParam("origin") Integer originId, @RequestParam("tier") Integer tierId,
			HttpSession session) {
		
		Fighter fighter = new Fighter(1, name, os.getOrigin(originId), ts.getTier(tierId));
		fs.saveFighter(fighter);
	}

}
