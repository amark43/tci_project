package com.gradle.project.gradle.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gradle.project.gradle.domain.Employee;
import com.gradle.project.gradle.dto.BonusDto;
import com.gradle.project.gradle.dto.EmployeeDto;

@Service
public interface BonusCalculatorService {

	Map<String, List<EmployeeDto>> calculator(List<BonusDto> bonusDto);

	void insertEmployeeDetails(List<BonusDto> bonusDto);

	Map<String, List<EmployeeDto>> getEligibleEmployee();

}
