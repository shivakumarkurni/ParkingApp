package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ParkingSlotsDTO;
import com.hcl.parking.entity.Employee;
import com.hcl.parking.entity.ParkingSlots;
import com.hcl.parking.repository.EmployeeRepository;
import com.hcl.parking.repository.ParkingSlotsRepository;

@Service
public class ParkingSlotsService {

	@Autowired
	ParkingSlotsRepository parkingSlotsRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public String assigningParkingSlot(ParkingSlotsDTO parkingSlotsDTO) {

		// BeanUtils.copyProperties(parkingSlotsDTO, parkingSlots);

		LocalDate date = LocalDate.now();
		int year = date.getYear();

		List<Employee> employees = employeeRepository.findAll();
		ParkingSlots parkingSlots = null;
		String res = null;

		for (Employee employee : employees) {

			parkingSlots = new ParkingSlots();

			if (employee.getDesignation().equals("President") || employee.getDesignation().equals("Vice President")
					|| (year - employee.getJoinedYear() >= 15)) {

				parkingSlots.setEmployee(employee);
				parkingSlots.setFloor(parkingSlotsDTO.getFloor());
				parkingSlots.setStatus(parkingSlotsDTO.getStatus());

				parkingSlotsRepository.save(parkingSlots);
				res = "parking slot created";
			}

			else {
				res = "Slot not created";
			}

		}

		return res;

	}

}
