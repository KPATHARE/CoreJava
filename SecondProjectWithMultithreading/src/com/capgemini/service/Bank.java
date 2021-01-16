package com.capgemini.service;
import com.capgemini.exception.AmountRequiredException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public interface Bank {
	String createAccount(int accountNumber, int amount) throws AmountRequiredException;
	int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
	int[] fundTransfer(int accountNumber, int accountNumber1, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
}


