package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.EmployeeDTO;
import com.hcl.parking.service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee/create")
	public ResponseEntity<String> employeeRegistration(@RequestBody EmployeeDTO employeeDto) {

		return new ResponseEntity<String>(employeeService.employeeRegistration(employeeDto), HttpStatus.CREATED);
	}

}
