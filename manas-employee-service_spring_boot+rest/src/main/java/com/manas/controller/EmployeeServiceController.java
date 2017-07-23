package com.manas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manas.domain.Employee;
import com.manas.service.EmployeeService;

@RestController
@RequestMapping("/employeeService")
public class EmployeeServiceController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/search")
	public Employee getEmployee(@RequestParam(value = "employeeId") int employeeId) {
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		
		return employeeService.searchEmployee(employee);
	}

}
