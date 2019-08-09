package com.hcl.parking.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ParkingSlotRequestDTO;
import com.hcl.parking.entity.ParkingSlotRequest;
import com.hcl.parking.exception.ParkingSlotRequestException;
import com.hcl.parking.repository.ParkingSlotRequestRepository;

@Service
public class ParkingSlotRequestService {

	@Autowired
	ParkingSlotRequestRepository parkingSlotRequestRepository;

	public String slotRequest(ParkingSlotRequestDTO parkingSlotRequestDTO) {

		ParkingSlotRequest parkingSlotRequest = new ParkingSlotRequest(0, 0);

		BeanUtils.copyProperties(parkingSlotRequestDTO, parkingSlotRequest);
		parkingSlotRequest.setRequestedDate(LocalDate.now());

		ParkingSlotRequest parkingSlot = parkingSlotRequestRepository.save(parkingSlotRequest);

		if (parkingSlot != null)
			return "Your request is accepted";
		else
			throw new ParkingSlotRequestException("No slot is free plz try again later");

	}

}
