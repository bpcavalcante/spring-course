package com.springcourse.resource.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springcourse.exception.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ApiError> handleNotFoundExcpetion(NotFoundException ex){
		ApiError error = new ApiError(HttpStatus.NOT_EXTENDED.value(), ex.getMessage(), new Date());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
