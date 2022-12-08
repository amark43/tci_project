package com.gradle.project.gradle.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradle.project.gradle.domain.Employee;
import com.gradle.project.gradle.dto.BonusDto;
import com.gradle.project.gradle.dto.EmployeeDto;

@Service
public class BonusCalculatorServiceImpl implements BonusCalculatorService {

	@Autowired
	private EmployeMapperService employeeMapperService;
	
	@Override
	public Map<String, List<EmployeeDto>> calculator(List<BonusDto> listOfBonus) {
		List<BonusDto> bonusEmpList = listOfBonus.stream()
				.filter(i -> i.getJoiningDate().isBefore(LocalDate.now()) && i.getExitDate().isAfter(LocalDate.now()))
				.sorted((a, b) -> a.getEmpName().compareToIgnoreCase(b.getEmpName())).toList();
		return employeeMapperService.map(bonusEmpList);
	}

	@Override
	public void insertEmployeeDetails(List<BonusDto> bonusDto) {
		List<Employee> empList = bonusDto.stream().map(this::mapToEmployee).toList();
		employeeMapperService.saveEmployee(empList);
	}
	
	private Employee mapToEmployee(BonusDto bonusData){
		Employee emp= new Employee();
		emp.setEmpName(bonusData.getEmpName());
		emp.setAmount(bonusData.getAmount());
		emp.setCurrency(bonusData.getCurrency());
		emp.setJoiningDate(bonusData.getJoiningDate());
		emp.setExitDate(bonusData.getExitDate());
		return emp;
	}

	@Override
	public Map<String, List<EmployeeDto>> getEligibleEmployee() {
		List<Employee> empList = employeeMapperService.getEligibleEmployee().stream().sorted((a,b)->a.getEmpName().
				compareToIgnoreCase(b.getEmpName())).collect(Collectors.toList());
		return employeeMapperService.mapEmpData(empList);
	}
}
