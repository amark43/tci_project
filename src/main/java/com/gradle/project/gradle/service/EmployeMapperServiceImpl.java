package com.gradle.project.gradle.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradle.project.gradle.domain.Employee;
import com.gradle.project.gradle.dto.BonusDto;
import com.gradle.project.gradle.dto.EmployeeDto;
import com.gradle.project.gradle.repository.EmployeeRepo;

@Service
public class EmployeMapperServiceImpl implements EmployeMapperService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Map<String, List<EmployeeDto>> map(List<BonusDto> listOfBonus) {
		return listOfBonus.stream().collect(Collectors.groupingBy(BonusDto::getCurrency, 
					Collectors.mapping(this::mapBonusToEmployee, Collectors.toList())));
	}

	private EmployeeDto mapBonusToEmployee(BonusDto it) {
		EmployeeDto emp = new EmployeeDto();
		emp.setAmount(it.getAmount());
		emp.setName(it.getEmpName());
		return emp;
	}

	@Override
	public void saveEmployee(List<Employee> empList) {
		employeeRepo.saveAll(empList);
	}
	
	
//	@Override
	public List<Employee> getEligibleEmployee() {
		return employeeRepo.findAllByJoiningDateLessThanEqualAndExitDateGreaterThanEqual(LocalDate.now(),LocalDate.now());
	}

	@Override
	public Map<String, List<EmployeeDto>> mapEmpData(List<Employee> empList) {
		return empList.stream().collect(Collectors.groupingBy(Employee::getCurrency, 
				Collectors.mapping(this::mapEmployeeToEmployeeDto, Collectors.toList())));
	}
	
	private EmployeeDto mapEmployeeToEmployeeDto(Employee empData) {
		EmployeeDto emp = new EmployeeDto();
		emp.setAmount(empData.getAmount());
		emp.setName(empData.getEmpName());
		return emp;
	}
	
}
