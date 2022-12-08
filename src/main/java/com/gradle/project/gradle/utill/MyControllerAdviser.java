package com.gradle.project.gradle.utill;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdviser {
	
	
	@ExceptionHandler(DateTimeParseException.class)
	ResponseEntity<Object>parseException(DateTimeParseException exception){
			return new ResponseEntity<>(exception.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
		}
	
//	@ExceptionHandler(DateTimeParseException.class)
//	ResponseEntity<Object>parseException(DateTimeParseException exception){
//			return new ResponseEntity<>(exception.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
//		}
}
