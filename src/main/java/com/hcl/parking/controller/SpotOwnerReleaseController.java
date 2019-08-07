package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.SpotOwnerReleaseDTO;
import com.hcl.parking.service.SpotOwnerReleaseService;

@RestController
public class SpotOwnerReleaseController {

	@Autowired
	SpotOwnerReleaseService spotOwnerReleaseService;

	@PostMapping("/parking/slotRelease")
	public ResponseEntity<String> slotRelease(@RequestBody SpotOwnerReleaseDTO spotOwnerReleaseDTO) {

		return new ResponseEntity<String>(spotOwnerReleaseService.slotRelease(spotOwnerReleaseDTO), HttpStatus.CREATED);

	}

}
