
public class Client {

	public static void main(String[] args) throws AmountRequiredException {
		Bank bank = new Bank();
		
		System.out.println(bank.createAccount(101, 3000));
		System.out.println(bank.createAccount(102, 3000));
		
		try
		{
			System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
			System.out.println("Balance="+bank.depositAmount(102,2000));
			
			System.out.println("Fund Transfer="+bank.fundTransfer(101, 102, 1000));
			System.out.println("Balance="+bank.depositAmount(102,200));
			System.out.println("Balance="+bank.depositAmount(101,200));
			System.out.println("Fund Transfer="+bank.fundTransfer(102,101,1000));
			
		}catch(InvalidAccountNumberException i)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ie){
			System.out.println("insufficient balance");
		}

	}

}
