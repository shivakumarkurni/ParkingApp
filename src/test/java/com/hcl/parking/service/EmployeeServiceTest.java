package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.EmployeeDTO;
import com.hcl.parking.entity.Employee;
import com.hcl.parking.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepository employeeRepository;
	
	Employee employee;
	EmployeeDTO employeeDto;
	CommoResponseDto commonResponseDto;
	
	@Before
	public void setUp()
	{
		employee=getEmployee();
		employeeDto=getEmployeeDto();
		commonResponseDto=getCommonResponseDto();
	}

	@Test
	public void testEmployeeRegistration() {

	

		Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);
		
		CommoResponseDto value=employeeService.employeeRegistration(employeeDto);
		assertEquals(commonResponseDto.getMessage(), value.getMessage());

	}
	
	public EmployeeDTO getEmployeeDto()
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(1);
		employeeDTO.setName("raj");
		employeeDTO.setAddress("bngl");
		employeeDTO.setDesignation("s/w");
		employeeDTO.setJoinedYear(1994);
		employeeDTO.setMobileNo(123456);
		return employeeDTO;
	}
	public Employee getEmployee()
	{
		

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setName("raj");
		employee.setAddress("bngl");
		employee.setDesignation("s/w");
		employee.setJoinedYear(1994);
		employee.setMobileNo(123456);
		
		return employee;
	}
	public CommoResponseDto getCommonResponseDto()
	{
		return new CommoResponseDto("Registration success");
	}
}
