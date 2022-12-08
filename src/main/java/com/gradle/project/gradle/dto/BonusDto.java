package com.gradle.project.gradle.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BonusDto {
	
	private String empName;
	private int amount;
	private String currency;
	@JsonFormat(pattern = "MMM-dd-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate joiningDate;
	@JsonFormat(pattern = "MMM-dd-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate exitDate;
	
	
}
