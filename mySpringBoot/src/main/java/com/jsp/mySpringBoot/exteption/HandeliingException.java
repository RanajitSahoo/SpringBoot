package com.jsp.mySpringBoot.exteption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.mySpringBoot.Response.ResponseStructure;


@RestControllerAdvice
public class HandeliingException {
	
	@ExceptionHandler(value=StudentNoFoundException.class)
	public ResponseStructure<StudentNoFoundException> exceptionHandeller(StudentNoFoundException s){
		ResponseStructure<StudentNoFoundException> res = new ResponseStructure<StudentNoFoundException>();
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage(s.getMessage());
		res.setData(s);
		return res;
	}
	
}
