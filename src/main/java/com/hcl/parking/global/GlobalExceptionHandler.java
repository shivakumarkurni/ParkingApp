package com.hcl.parking.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.parking.exception.ParkingSlotRequestException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ParkingSlotRequestException.class)
	public ResponseEntity<ExceptionPojo> globalExceptionHandler(ExceptionPojo ex, WebRequest request) {
     
		ExceptionPojo employeeExceptionPojo = new ExceptionPojo(ex.getMessage());

		return new ResponseEntity<ExceptionPojo>(employeeExceptionPojo, HttpStatus.NOT_FOUND);
	}

}
