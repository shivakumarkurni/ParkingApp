package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.entity.ParkingSlotRequest;
import com.hcl.parking.repository.ParkingSlotRequestRepository;

@Service
public class AllotingService {
	
	@Autowired
	ParkingSlotRequestRepository parkingSlotRequestRepository;
	
	
	public String allotingRequest() {
		
		LocalDate date=LocalDate.now();
		
		
		List<ParkingSlotRequest> request=parkingSlotRequestRepository.findByRequestedDate(date);
		
		for (ParkingSlotRequest parkingSlotRequest : request) {
			
			System.out.println(parkingSlotRequest);
			
		}
		
		return "";
	}

}
