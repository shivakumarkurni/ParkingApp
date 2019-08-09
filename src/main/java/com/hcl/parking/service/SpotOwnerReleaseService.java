package com.hcl.parking.service;

import java.time.LocalDate;

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
		LocalDate addDate = null;

		SpotOwnerRelease spotOwnerRelease = new SpotOwnerRelease();

		BeanUtils.copyProperties(spotOwnerReleaseDto, spotOwnerRelease);

		int psId = spotOwnerReleaseDto.getParkingSlots().getPsId();

		ParkingSlots parkingSlots = parkingSlotsRepository.findById(psId).get();

		int days = spotOwnerRelease.getDays();

		if (days > 1) {
			LocalDate date = LocalDate.now();
			addDate = date.plusDays(days);
		}

		spotOwnerRelease.setParkingSlots(parkingSlots);
		spotOwnerRelease.setAvailableTillDate(addDate);

		spotOwnerReleaseRepository.save(spotOwnerRelease);

		return "Slot Release request accepted";

	}

}
