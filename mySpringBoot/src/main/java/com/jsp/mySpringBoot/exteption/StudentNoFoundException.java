package com.jsp.mySpringBoot.exteption;

public class StudentNoFoundException extends RuntimeException {
	private String message;

	public StudentNoFoundException(String msg) {
		this.message=msg;
	}
	
	

	@Override
	public String getMessage() {
		return message;
	}
}
