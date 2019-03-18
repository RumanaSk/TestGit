package com.shopping.component;

public class UserLoginException extends RuntimeException {
	
	public UserLoginException() {
		super();
		
	}

	public UserLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserLoginException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public UserLoginException(String message) {
		super(message);
	
	}

	public UserLoginException(Throwable cause) {
		super(cause);
		
	}
	

}

