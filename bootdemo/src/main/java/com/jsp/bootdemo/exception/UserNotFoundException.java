package com.jsp.bootdemo.exception;




public class UserNotFoundException extends RuntimeException{
	
	private String messsage;

	public UserNotFoundException(String messsage) {
		this.messsage = messsage;
	}
	@Override
	public String getMessage() {
		
		return messsage;
	}
	

}
