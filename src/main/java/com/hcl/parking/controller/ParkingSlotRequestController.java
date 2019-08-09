package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ParkingSlotRequestDTO;
import com.hcl.parking.service.ParkingSlotRequestService;

@RestController
public class ParkingSlotRequestController {

	@Autowired
	ParkingSlotRequestService parkingSlotRequestService;

	@PostMapping("/slotRequest")
	public ResponseEntity<String> slotRequest(@RequestBody ParkingSlotRequestDTO parkingSlotRequestDTO) {

		return new ResponseEntity<String>(parkingSlotRequestService.slotRequest(parkingSlotRequestDTO),
				HttpStatus.CREATED);
	}

}
