package com.jsp.bootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.bootdemo.ResponseStructure.ResponseStructure;


@RestControllerAdvice
public class HandellingException {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseStructure<UserNotFoundException> exceptionHandellor(UserNotFoundException u){
		ResponseStructure<UserNotFoundException> res = new ResponseStructure<UserNotFoundException>();
		res.setStatuscode(HttpStatus.NOT_FOUND.value());
		res.setMessage(u.getMessage());
		res.setData(u);
		return res;
	}

}
