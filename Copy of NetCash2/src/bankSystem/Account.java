package bankSystem;

public class Account {
	
	private String accountNumber;
	private String pin;
	private double balance;
	
	public Account(String accountNumber, String pin, double balance)
	{
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}
	
	public boolean validatePin(String enteredPin)
	{
		if(this.pin.equals(enteredPin))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void increaseBalance(double value)
	{
		this.balance += value;
	}
	
	public void decreaseBalance(double value)
	{
		this.balance -= value;
	}
}
