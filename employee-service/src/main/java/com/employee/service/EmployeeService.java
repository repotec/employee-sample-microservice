package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.dto.EmployeeDTO;
import com.employee.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public EmployeeDTO findEmployeeById(Long employeeId){
		return employeeMapper.employeeToEmployeeDTO(employeeRepository.findByEmployeeId(employeeId));
	}
}
