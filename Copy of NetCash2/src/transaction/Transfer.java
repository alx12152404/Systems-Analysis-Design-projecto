package transaction;

import bankSystem.Bank;
import log.Log;
import log.TransferLog;
import session.Session;
import userInterface.GUI;

public class Transfer extends Transaction {
	
	private String value;
	private String targetAccountNumber;
	private double targetBalance;
	
	public Transfer(String accountNumber, GUI gui, Bank bank, Session session, Log log)
	{
		super(accountNumber, gui, bank, session, log);
		
	}

	@Override
	public void executeTransaction() 
	{
		Bank bank = getBank();
		GUI gui = getGUI();
		Session session = getSession();
		TransferLog log = (TransferLog) getLog();
		boolean actionComplete = false;
		double balance;
		double amount;
		
		while(!actionComplete)
		{
			targetAccountNumber = gui.getTransferAccountNumber();
			if(!session.verifySessionIntegrity()) break;
			if(bank.verifyTargetAccount(targetAccountNumber))
			{
			   value = gui.getTransferAmount();
			
			if(!session.verifySessionIntegrity()) break;
				
			if( value != "EXIT")
			{
				balance = bank.getBalance(getAccountNumber());
				targetBalance = bank.getBalance(targetAccountNumber);
				amount = Double.parseDouble(value);
				
				if(amount <= balance)
				{
						bank.decreaseBalance(getAccountNumber(), amount);
						bank.increaseBalance(targetAccountNumber, amount);
						gui.displaySuccesfulTransferMessage(targetAccountNumber, amount);
						log.setAttributes(amount, (balance - amount), targetAccountNumber, targetBalance);
						actionComplete = true;			
				}
				else
				{
					gui.displayInsufCashAccMessage();
				}
			}
			else
			{
				actionComplete = true;
			}
			}
			else
			{
				gui.displayNoAccount();
			}
		}	
	}
	
	public String getAccountNumber()
	{
		return super.getAccountNumber();		
	}
}