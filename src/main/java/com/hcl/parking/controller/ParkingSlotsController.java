package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ParkingSlotsDTO;
import com.hcl.parking.service.ParkingSlotsService;

@RestController
public class ParkingSlotsController {
	
	@Autowired
	ParkingSlotsService parkingSlotsService;
	
	
	@PostMapping("/employee/parkingSlot")
	public ResponseEntity<String> allotingParkingSlot(@RequestBody ParkingSlotsDTO parkingSlotsDTO) {
		
		return new ResponseEntity<String>(parkingSlotsService.assigningParkingSlot(parkingSlotsDTO),HttpStatus.CREATED);
		
		
		
	}

}
