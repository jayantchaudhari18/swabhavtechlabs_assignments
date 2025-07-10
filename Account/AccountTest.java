package com.aurionpro.test;
import com.aurionpro.exceptions.MinimumBalanceViolationException;
import com.aurionpro.exceptions.NegativeAmountException;
import com.aurionpro.model.Account;
import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("How many account do you want to create?");
		int n=scanner.nextInt();
		Account accounts[]=new Account[n];
		for(int i=0;i<n;i++) {
			accounts[i]=createAccount(scanner,accounts,i);
			System.out.println("Account Created"+(i+1));
			accounts[i].display();
			
		}
		
		
		int choice;
		do {
			
			System.out.println("Enter the index of the account:");
			int index=scanner.nextInt();
			
			Account selectedAccount=accounts[index];
			
			System.out.println("ENTER YOUR CHOICE:");
			System.out.println("1. Create an Account\n2.View Balance\n3.Deposit\n4.Withdraw\n5.Exit");
			choice =scanner.nextInt();
			
			switch(choice) {
			case 1:selectedAccount.display();
			       break;
			       
			case 2:selectedAccount.viewBalance();
			       break;
			       
			case 3:System.out.println("Enter the amount to deposit: ");
			       
			       try {
			    	   double deposit_amount=scanner.nextDouble();
			    	   selectedAccount.deposit(deposit_amount);
			       }
			       catch(NegativeAmountException exception) {
			    	   System.out.println(exception.getMessage()); 
			    	   
			       }
		           break;    
		           
			case 4:System.out.println("Enter amount to withdraw:");
			       try {
			    	   double withdraw_amount=scanner.nextDouble();
				       selectedAccount.withdraw(withdraw_amount);
			       }
			       catch(MinimumBalanceViolationException exception) {
			    	   System.out.println(exception.getMessage()); 
			       }
			       catch(NegativeAmountException exception) {
			    	   System.out.println(exception.getMessage()); 
			       }
			       
		           break;    
		           
			case 5:System.out.println("Thankyou for transacting with us");
			       break;
			}
			
		}while(choice!=5);
		
		
		
		
		
		
		

	}
	
	public static Account createAccount(Scanner scanner,Account accounts[],int count) {
		scanner.nextLine();
		System.out.println("Enter Name: ");
		String name=scanner.nextLine();
		System.out.println("Account type:savings or current: ");
		String account_type=scanner.nextLine();
		System.out.println("Enter amount to deposit(Amount should be greater than 500):");
		Double balance=scanner.nextDouble();
		try {
			if(balance<0) {
				throw new NegativeAmountException();
			}
			throw new MinimumBalanceViolationException();
		}
		catch(NegativeAmountException exception){
			exception.getMessage();
			
		}
		catch(MinimumBalanceViolationException exception) {
			exception.getMessage();		}
		
		String account_number;
		
		do {
			double randomDouble = Math.random(); 
	        // Scale to the 7-digit range and cast to integer
	        int sevenDigitNumber = (int)(randomDouble * 9000000) + 1000000;
	        account_number="IDBI1000"+sevenDigitNumber;
		}while(!isUniqueAccountNumber(account_number,accounts,count));
		
        
        return new Account(account_number,name,balance,account_type);
		
	}
	
	public static boolean isUniqueAccountNumber(String account_number,Account[] accounts,int count) {
		for(int i=0;i<count;i++) {
			if(accounts[i]!=null&&accounts[i].getAccount_number().equals(account_number)) {
				return false;
			}
			
		}
		return true;
		
	}

}
