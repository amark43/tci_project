package com.gradle.project.gradle.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String empName;
	private int amount;
	private String currency;
	@JsonFormat(pattern = "MMM-dd-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate joiningDate;
	@JsonFormat(pattern = "MMM-dd-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate exitDate;

}
