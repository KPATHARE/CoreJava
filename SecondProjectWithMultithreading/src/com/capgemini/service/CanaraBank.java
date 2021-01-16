package com.capgemini.service;
import java.util.LinkedList;

import com.capgemini.beans.Account;
import com.capgemini.exception.AmountRequiredException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
public class CanaraBank implements Bank {
	private LinkedList<Account> accounts=new LinkedList<>();
	public String createAccount(int accountNumber,int amount) throws AmountRequiredException
	{	if(amount>=500) 
		{
		Account account = new Account(accountNumber,amount);
		
		accounts.add(account);
		{
		return "Account created successfully";
		}
	}
		throw new AmountRequiredException(); 
	}
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account=searchAccount(accountNumber);
		synchronized(account) {
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufficientBalanceException();
	}
	}
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()+amount)>=0)
		{
			account.setAmount(account.getAmount()+amount);
			return account.getAmount();
		}
		return amount;
		
	}
	public int[] fundTransfer(int senderAccount, int receiverAccount, int amount) throws InsufficientBalanceException, InvalidAccountNumberException
	{	Account sender=searchAccount(senderAccount);
		Account receiver=searchAccount(receiverAccount);
		
		if(sender.getAmount()>=amount) {
			sender.setAmount(sender.getAmount()+amount);
			receiver.setAmount(receiver.getAmount()+amount);
			int[] total= {sender.getAmount(), receiver.getAmount()+amount};
			return total;
	}
		throw new InsufficientBalanceException();
	}
	//}
}


	
	


