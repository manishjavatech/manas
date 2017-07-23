package com.manas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manas.domain.Employee;
import com.manas.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee searchEmployee(Employee employee) {
		
		return employeeRepository.findByEmployeeId(employee.getEmployeeId());
	}

}
