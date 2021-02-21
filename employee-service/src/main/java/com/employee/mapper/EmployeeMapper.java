package com.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.employee.dto.EmployeeDTO;
import com.employee.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	@Mapping(target = "employeeId", source = "employeeId")
	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "hireDate", source = "hireDate")
	@Mapping(target = "salary", source = "salary")
	@Mapping(target = "commissionPct", source = "commissionPct")
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
}
