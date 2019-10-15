package com.michael.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.app.beans.Origin;
import com.michael.app.services.OriginService;

@RestController
@RequestMapping(value="/origin")
@CrossOrigin(origins="http://localhost:4200")
public class OriginController {
	
	@Autowired
	private OriginService os;
	
	@RequestMapping(method=RequestMethod.POST)
	public void makeOrigin(@RequestParam("name") String name) {
		Origin origin = new Origin(null, name);
		os.saveOrigin(origin);
	}
}
