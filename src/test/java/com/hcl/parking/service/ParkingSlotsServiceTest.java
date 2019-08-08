package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.ParkingSlotsDTO;
import com.hcl.parking.entity.Employee;
import com.hcl.parking.entity.ParkingSlots;
import com.hcl.parking.repository.EmployeeRepository;
import com.hcl.parking.repository.ParkingSlotsRepository;

@RunWith(MockitoJUnitRunner.class)
public class ParkingSlotsServiceTest {

	@InjectMocks
	ParkingSlotsService ParkingSlotsService;

	@Mock
	ParkingSlotsRepository parkingSlotsRepository;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	public void testAssigningParkingSlot() {

		LocalDate date = LocalDate.now();
		int year = date.getYear();

		Employee emp1 = new Employee();

		List<Employee> empList = new ArrayList<>();

		ParkingSlots parkingSlots = null;

		emp1.setEmpId(1);
		emp1.setName("raj");
		emp1.setAddress("bngl");
		emp1.setDesignation("s/w");
		emp1.setJoinedYear(1993);
		emp1.setMobileNo(123456);

		Employee emp2 = new Employee();

		emp2.setEmpId(2);
		emp2.setName("raj");
		emp2.setAddress("bngl");
		emp2.setDesignation("President");
		emp2.setJoinedYear(2019);
		emp2.setMobileNo(123456);

		empList.add(emp1);
		empList.add(emp2);
		ParkingSlotsDTO parkingSlotsDTO = new ParkingSlotsDTO();

		parkingSlotsDTO.setFloor("1floor");
		parkingSlotsDTO.setStatus("accepted");

		Mockito.when(employeeRepository.findAll()).thenReturn(empList);

		for (Employee employee : empList) {

			parkingSlots = new ParkingSlots();

			parkingSlots.setEmployee(employee);
			parkingSlots.setFloor(parkingSlotsDTO.getFloor());
			parkingSlots.setStatus(parkingSlotsDTO.getStatus());

			Mockito.when(parkingSlotsRepository.save(Mockito.any())).thenReturn(parkingSlots);

			String value = ParkingSlotsService.assigningParkingSlot(parkingSlotsDTO);
			assertEquals("parking slot created", value);

		}

	}

	@Test
	public void testingElseCaseAssigningParkingSlot() {

		LocalDate date = LocalDate.now();
		int year = date.getYear();

		Employee emp1 = new Employee();

		List<Employee> empList = new ArrayList<>();

		ParkingSlots parkingSlots = null;

		emp1.setEmpId(1);
		emp1.setName("raj");
		emp1.setAddress("bngl");
		emp1.setDesignation("s/w");
		emp1.setJoinedYear(2019);
		emp1.setMobileNo(123456);

		Employee emp2 = new Employee();

		emp2.setEmpId(2);
		emp2.setName("raj");
		emp2.setAddress("bngl");
		emp2.setDesignation("s/w");
		emp2.setJoinedYear(2019);
		emp2.setMobileNo(123456);

		empList.add(emp1);
		empList.add(emp2);
		ParkingSlotsDTO parkingSlotsDTO = new ParkingSlotsDTO();

		parkingSlotsDTO.setFloor("1floor");
		parkingSlotsDTO.setStatus("accepted");

		Mockito.when(employeeRepository.findAll()).thenReturn(empList);

		for (Employee employee : empList) {

			parkingSlots = new ParkingSlots();

	

				parkingSlots.setEmployee(employee);
				parkingSlots.setFloor(parkingSlotsDTO.getFloor());
				parkingSlots.setStatus(parkingSlotsDTO.getStatus());

			//	Mockito.when(parkingSlotsRepository.save(parkingSlots)).thenReturn(parkingSlots);

				String value = ParkingSlotsService.assigningParkingSlot(parkingSlotsDTO);
				assertEquals("Slot not created", value);

			}

		}

	}


