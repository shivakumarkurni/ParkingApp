package com.hcl.parking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.EmployeeDTO;
import com.hcl.parking.entity.Employee;
import com.hcl.parking.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public CommoResponseDto employeeRegistration(EmployeeDTO employeeDto) {

		Employee employee = new Employee();

		BeanUtils.copyProperties(employeeDto, employee);

		employeeRepository.save(employee);

		return new CommoResponseDto("Registration success");

	}

}
