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

	public String employeeRegistration(EmployeeDTO employeeDto) {

		Employee employee = new Employee();

		BeanUtils.copyProperties(employeeDto, employee);

		Employee emp = employeeRepository.save(employee);

		if (emp != null)

			return "Employee registered successfully";

		else
			return "Employee not registered";

	}

}
