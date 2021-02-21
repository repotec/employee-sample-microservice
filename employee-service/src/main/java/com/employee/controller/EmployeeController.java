package com.employee.controller;


import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.feign.EmployeeCommissionProxy;
import com.employee.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeCommissionProxy employeeCommissionProxy;
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(path="/{employeeId}")
	public EmployeeDTO findEmployeeById(@PathVariable("employeeId") Long employeeId){
		logger.info("start calling calculate commission proxy service");
		
		EmployeeDTO employee = employeeService.findEmployeeById(employeeId);
		
		BigDecimal employeeTotalSalary = employeeCommissionProxy.calculateCommission(employee.getSalary(), employee.getCommissionPct());
		employee.setTotalSalary(employeeTotalSalary);
		
		return employee;
	}
}
