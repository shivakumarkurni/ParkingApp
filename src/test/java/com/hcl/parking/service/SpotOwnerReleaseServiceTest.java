package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.parking.dto.SpotOwnerReleaseDTO;
import com.hcl.parking.entity.Employee;
import com.hcl.parking.entity.ParkingSlots;
import com.hcl.parking.entity.SpotOwnerRelease;
import com.hcl.parking.repository.ParkingSlotsRepository;
import com.hcl.parking.repository.SpotOwnerReleaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class SpotOwnerReleaseServiceTest {

	@InjectMocks
	SpotOwnerReleaseService spotOwnerReleaseService;

	@Mock
	SpotOwnerReleaseRepository spotOwnerReleaseRepository;

	@Mock
	ParkingSlotsRepository parkingSlotsRepository;

	@Test
	public void testSlotRelease() {

		ParkingSlots parkingSlots = new ParkingSlots();
		Employee emps = new Employee();
		parkingSlots.setEmployee(emps);
		parkingSlots.setFloor("2floor");
		parkingSlots.setStatus("accepted");
		parkingSlots.setPsId(1);

		SpotOwnerReleaseDTO spotOwnerReleaseDto = new SpotOwnerReleaseDTO();
		SpotOwnerRelease spotOwnerRelease = new SpotOwnerRelease();

		spotOwnerReleaseDto.setSoReleaseId(1);
		spotOwnerReleaseDto.setUserId(1);
		spotOwnerReleaseDto.setDays(3);
		spotOwnerReleaseDto.setParkingSlots(parkingSlots);

		BeanUtils.copyProperties(spotOwnerReleaseDto, spotOwnerRelease);

		int psId = spotOwnerReleaseDto.getParkingSlots().getPsId();

		//ParkingSlots parkingSlot = parkingSlotsRepository.findById(psId).get();
		
		Mockito.when(parkingSlotsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(parkingSlots));

		spotOwnerRelease.setParkingSlots(parkingSlots);

		Mockito.when(spotOwnerReleaseRepository.save(Mockito.any())).thenReturn(spotOwnerRelease);

		String value = spotOwnerReleaseService.slotRelease(spotOwnerReleaseDto);

		assertEquals("Slot Release request accepted", value);

	}

}
