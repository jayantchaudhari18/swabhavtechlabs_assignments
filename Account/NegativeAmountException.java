package com.aurionpro.exceptions;

public class NegativeAmountException extends RuntimeException{
	private int amount;
	
	public NegativeAmountException(int amount) {
		super();
		this.amount = amount;
	}

	public NegativeAmountException() {
		super();
	}

	public String getMessage() {
		return "The entered amount is negative.Enter positive values";
	}

}
