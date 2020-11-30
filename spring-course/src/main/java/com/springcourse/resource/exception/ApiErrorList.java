package com.springcourse.resource.exception;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiErrorList extends ApiError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994279692777220830L;
	
	private List<String> errors;
	
	public ApiErrorList(int code, String msg, Date date, List<String> errors) {
		super(code, msg, date);
		this.errors = errors;
	}
	
	

}
