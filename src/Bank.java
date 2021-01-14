import java.util.LinkedList;

public class Bank implements Bank1 {
	
	
	LinkedList<Account> accounts=new LinkedList<>();
	
	
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
	public Account searchAccount(int accountNumber)throws InvalidAccountNumberException
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
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
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
	public int fundTransfer(int accountNumber, int accountNumber1, int amount) throws InsufficientBalanceException, InvalidAccountNumberException
	{	Account account=searchAccount(accountNumber);
		Account account1=searchAccount(accountNumber1);
		if((account.getAmount()-amount)>=0) {
			account.setAmount(account.getAmount()+amount);
			account1.setAmount(account1.getAmount()+amount);
			return account1.getAmount();
		}
		throw new InsufficientBalanceException();
		
	}
	
	
	
}
