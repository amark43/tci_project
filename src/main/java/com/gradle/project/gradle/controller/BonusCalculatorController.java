package com.gradle.project.gradle.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradle.project.gradle.dto.BonusDto;
import com.gradle.project.gradle.dto.EmployeeDto;
import com.gradle.project.gradle.service.BonusCalculatorService;
import com.gradle.project.gradle.utill.ResponseHandler;

@RestController
public class BonusCalculatorController {
	
	@Autowired 
	private BonusCalculatorService bonusCalculatorService;
	
	@PostMapping("/tci/bonus/eligibility")
	ResponseEntity<Object> checkEmployeeBonusEligibility(@RequestBody List<BonusDto> bonusDto) {
		Map<String, List<EmployeeDto>> response = bonusCalculatorService.calculator(bonusDto);
			return ResponseHandler.response(response, "","Data Fetched Successfully");
	}
	
	
	@PostMapping("/tci/employee/details")
	ResponseEntity<Object> insertEmployeeDetails(@RequestBody List<BonusDto> bonusDto) {
		bonusCalculatorService.insertEmployeeDetails(bonusDto);
		return ResponseHandler.response(Optional.empty(), "","Data insert Successfully !");
	}
	
	
	@GetMapping("/tci/employee/eligibility")
	ResponseEntity<Object> getEligibleEmployee() {
		Map<String, List<EmployeeDto>> response =bonusCalculatorService.getEligibleEmployee();
		return ResponseHandler.response(response, "","Data Fetched Successfully");
	}
	
	
	
}
