package com.gradle.project.gradle.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gradle.project.gradle.domain.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	List<Employee> findAllByJoiningDateLessThanEqualAndExitDateGreaterThanEqual(LocalDate joiningDate,LocalDate exitDate);
	
	

}
