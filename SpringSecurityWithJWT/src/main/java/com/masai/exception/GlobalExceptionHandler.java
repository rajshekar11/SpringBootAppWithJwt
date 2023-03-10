package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> productExceptionHandler(ProductException me,WebRequest wr){
		MyError m=new MyError();
		m.setTimestamp(LocalDateTime.now());
		m.setMessage(me.getMessage());
		m.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyError>(m,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MerchantException.class)
	public ResponseEntity<MyError> merchantExceptionHandler(MerchantException me,WebRequest wr){
		MyError m=new MyError();
		m.setTimestamp(LocalDateTime.now());
		m.setMessage(me.getMessage());
		m.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyError>(m,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> globalExceptionHandler(Exception me,WebRequest wr){
		MyError m=new MyError();
		m.setTimestamp(LocalDateTime.now());
		m.setMessage(me.getMessage());
		m.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyError>(m,HttpStatus.BAD_REQUEST);
	}
	
	
}
