package com.capgemini.service;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public class BankRunner implements Runnable {
	CanaraBank bank;
	public BankRunner(CanaraBank bank) {
		super();
		this.bank=bank;
	}
	
	public void run() {
		try {
			if(Thread.currentThread().getName().equals("first")) {
				System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
				
			}else {
				System.out.println("Balance = "+bank.withdrawAmount(102, 2000));
			}
		}
		
			catch(InvalidAccountNumberException i)
			{
				System.out.println("Invalid account number ");
			}
			catch(InsufficientBalanceException ie){
				System.out.println("insufficient balance");
			}
	}
}


