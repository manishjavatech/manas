package com.manas;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import com.manas.model.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee employee) throws Exception {
		BigDecimal bonus=new BigDecimal(1111.00D);
		employee.setSalary(employee.getSalary().add(bonus));
		System.out.println("Processing..." + employee);
		return employee;
	}

}
