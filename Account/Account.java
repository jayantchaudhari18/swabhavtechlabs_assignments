package com.aurionpro.model;

import java.util.Scanner;

import com.aurionpro.exceptions.MinimumBalanceViolationException;
import com.aurionpro.exceptions.NegativeAmountException;

public class Account {
	private String account_number;
	private String name;
	private double balance;
	private String account_type;
	private double amount;

	Scanner scanner = new Scanner(System.in);

	// default constructor
	public Account() {
		account_number = "IDBI10003456789";
		name = "Jayant";
		balance = 100000;
		account_type = "Savings";
	}

	// constructor
	public Account(String account_number, String name, double balance, String account_type)  {
		this.account_number = account_number;
		this.name = name;
		if (balance < 500) {
			throw new MinimumBalanceViolationException();
		}
		this.balance = balance;
		this.account_type = account_type;
	}

	// setters and getters
	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {

		return balance;
	}

	public void setBalance(double balance) {
		
		this.balance = balance;
		if (balance < 500) {
			throw new MinimumBalanceViolationException();
		}
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public void deposit(double amount) {
		if(amount<0) {
			System.out.println("Invalid amount is entered");
			throw new NegativeAmountException();
		}
		
		
			balance = balance + amount;
			System.out.println(amount + " Rs deposited successfully.");
			System.out.println("Available balance: " + balance);

		

	}

	public void withdraw(double amount) {
		
			if (amount > 0) {
				if (balance - amount < 500) {
					System.out.println("Minimum balance should be Rs:500");
					throw new MinimumBalanceViolationException();
				} else {
					balance = balance - amount;
					System.out.println("Available balance: " + balance);
				}

			} else {
				System.out.println("Invalid amount entered");
				throw new NegativeAmountException();
			}
			
		
		
	
	}

	public void viewBalance() {
		System.out.println("Account Balance :" + balance);
	}

	public void display() {
		System.out.println("-------------------------------");
		System.out.println("Account_number: " + account_number);
		System.out.println("Account Name: " + name);
		System.out.println("Account Balance: " + balance);
		System.out.println("Account Type: " + account_type);
		System.out.println("-------------------------------");

	}

}
