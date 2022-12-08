package com.gradle.project.gradle.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gradle.project.gradle.domain.Employee;
import com.gradle.project.gradle.dto.BonusDto;
import com.gradle.project.gradle.dto.EmployeeDto;

@Service
public interface EmployeMapperService {

	Map<String, List<EmployeeDto>> map(List<BonusDto> bonus);

	void saveEmployee(List<Employee> empList);
	
	List<Employee> getEligibleEmployee();

	Map<String, List<EmployeeDto>> mapEmpData(List<Employee> empList);

}
