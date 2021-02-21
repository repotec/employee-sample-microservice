package com.employee.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private Date hireDate;
	private BigDecimal salary;
	private Double commissionPct;
	private BigDecimal totalSalary;
}
