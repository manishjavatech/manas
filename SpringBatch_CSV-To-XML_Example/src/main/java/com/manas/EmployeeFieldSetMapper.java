package com.manas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.manas.model.Employee;

public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		
		Employee employee = new Employee();
		employee.setId(fieldSet.readInt(0));
		employee.setName(fieldSet.readString(1));
		employee.setSalary(fieldSet.readBigDecimal(2));
		employee.setExprience(fieldSet.readInt(3));
		
		//default format yyyy-MM-dd
		//fieldSet.readDate(4);
		String date = fieldSet.readString(4);
		try {
			employee.setJoiningDate(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return employee;
		
	}

}