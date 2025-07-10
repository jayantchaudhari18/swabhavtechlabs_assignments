package com.aurionpro.exceptions;

public class OverdraftLimitReachException extends RuntimeException{
	
	public String getMessage() {
		return "Over Draft limit is reached";
	}

}
