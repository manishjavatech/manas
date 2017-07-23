package com.manas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.manas.domain.Employee;

@RepositoryRestResource
public interface EmployeeRepositoryRestResource extends JpaRepository<Employee, Integer>{
	 @Query("SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
	 Employee findByEmployeeId(@Param("employeeId") Integer employeeId);
	 
	 @Override
	public List<Employee> findAll();
}
