package com.masai.exception;

import lombok.Data;

@Data
public class MerchantException extends Exception {

	public MerchantException() {
		// TODO Auto-generated constructor stub
	}
	
	public MerchantException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
