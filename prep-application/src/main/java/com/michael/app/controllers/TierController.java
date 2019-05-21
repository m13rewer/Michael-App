package com.michael.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.app.beans.Origin;
import com.michael.app.beans.Tier;
import com.michael.app.services.OriginService;
import com.michael.app.services.TierService;

@RestController
@RequestMapping(value="/tier")
public class TierController {
	@Autowired
	private TierService ts;
	
	@RequestMapping(method=RequestMethod.POST)
	public void makeOrigin(@RequestParam("name") String name) {
		Tier tier = new Tier(1, name);
		ts.saveTier(tier);
	}
}
