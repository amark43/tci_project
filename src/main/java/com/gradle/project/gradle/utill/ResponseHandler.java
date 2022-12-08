package com.gradle.project.gradle.utill;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static final ResponseEntity<Object> response(Object data,String errorMessage,String successMesage){
		Map<String,Object>res= new HashMap<>();
		res.put("errorMessage", errorMessage);
		res.put("data", data);
		res.put("successMesage", successMesage);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}
