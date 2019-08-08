package com.hcl.parking.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.SpotOwnerReleaseDTO;
import com.hcl.parking.entity.ParkingSlots;
import com.hcl.parking.entity.SpotOwnerRelease;
import com.hcl.parking.repository.ParkingSlotsRepository;
import com.hcl.parking.repository.SpotOwnerReleaseRepository;

@Service
public class SpotOwnerReleaseService {

	@Autowired
	SpotOwnerReleaseRepository spotOwnerReleaseRepository;

	@Autowired
	ParkingSlotsRepository parkingSlotsRepository;

	public String slotRelease(SpotOwnerReleaseDTO spotOwnerReleaseDto) {

		SpotOwnerRelease spotOwnerRelease = new SpotOwnerRelease();

		BeanUtils.copyProperties(spotOwnerReleaseDto, spotOwnerRelease);
		
		int psId=spotOwnerReleaseDto.getParkingSlots().getPsId();
		
		ParkingSlots parkingSlots = parkingSlotsRepository.findById(psId).get();
		
		spotOwnerRelease.setParkingSlots(parkingSlots);

		spotOwnerReleaseRepository.save(spotOwnerRelease);

		return "Slot Release request accepted";

	}

}
