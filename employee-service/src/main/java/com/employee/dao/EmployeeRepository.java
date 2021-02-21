package com.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.employee.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	public Employee findByEmployeeId(Long employeeId);
}
