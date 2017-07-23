package com.manas;

import org.springframework.batch.item.ItemProcessor;

import com.manas.model.Employee;

public class CustomItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		BigDecimal bonus=new BigDecimal(1111.00D);
		employee.setSalary(employee.getSalary().add(bonus));
		System.out.println("Processing..." + item);
		return item;
	}

}
