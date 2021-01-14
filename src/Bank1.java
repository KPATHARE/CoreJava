
public interface Bank1 {
	String createAccount(int accountNumber, int amount) throws AmountRequiredException;
	Account searchAccount(int accountNumber) throws InvalidAccountNumberException;
	int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
	int fundTransfer(int accountNumber, int accountNumber1, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int showAmount(int amount);

}


