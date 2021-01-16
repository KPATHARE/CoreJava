package com.capgemini.view;
import com.capgemini.exception.AmountRequiredException;
import com.capgemini.service.BankRunner;
import com.capgemini.service.CanaraBank;

public class Client {
	public static void main(String[] args) {
		CanaraBank bank = new CanaraBank();
		try {
			System.out.println(bank.createAccount(101, 3000));
		} catch (AmountRequiredException e) {
			System.out.println("Minimum 500 amount required");
			e.printStackTrace();
		}
		try {
			System.out.println(bank.createAccount(102, 3000));
		} catch (AmountRequiredException e) {
			System.out.println("Minimum 500 amount required");
			e.printStackTrace();
		}
		
		BankRunner bankRunner=new BankRunner(bank);
		
		Thread firstThread=new Thread(bankRunner,"first");
		firstThread.start();
		
		Thread secondThread=new Thread(bankRunner,"second");
		secondThread.start();
	}
}
		
		
		
		
		
		