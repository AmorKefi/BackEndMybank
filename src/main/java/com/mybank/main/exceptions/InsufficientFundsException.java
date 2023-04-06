package com.mybank.main.exceptions;

public class InsufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = 6230382711355862167L;

	public InsufficientFundsException(String message) {
		super(message);
	}

	public InsufficientFundsException(String message, Throwable cause) {
		super(message, cause);
	}
}