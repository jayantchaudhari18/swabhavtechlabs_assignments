package com.aurionpro.exceptions;

public class MinimumBalanceViolationException extends RuntimeException{
	private int balance;

	public MinimumBalanceViolationException(int balance) {
		super();
		this.balance = balance;
	}

	public MinimumBalanceViolationException() {
		super();
	}
	
	public String getMessage() {
		return "Minimum Balance should be 500";
	}
   

}
