package com.masai.exception;

import lombok.Data;

@Data
public class ProductException extends Exception {

	public ProductException() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
