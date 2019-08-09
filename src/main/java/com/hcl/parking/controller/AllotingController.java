package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.service.AllotingService;

@RestController
public class AllotingController {
	
	@Autowired
	AllotingService allotingService;
	
	@GetMapping("/allotingSlot")
	public void allotingController() {
		allotingService.allotingRequest();
		
	}

}
