package transaction;

import atm.CashManager;
import bankSystem.Bank;
import log.Log;
import log.WithdrawalLog;
import session.Session;
import userInterface.GUI;

public class Withdrawal extends Transaction{
	
	private String value;
	private CashManager cashManager;
	
	
	public Withdrawal(String accountNumber, GUI gui, Bank bank, Session session, Log log, CashManager cashManager)
	{
		super(accountNumber, gui, bank, session, log);
		this.cashManager = cashManager;
	}


	@Override
	public void executeTransaction() {
		// TODO Auto-generated method stub
		Bank bank = getBank();
		GUI gui = getGUI();
		Session session = getSession();
		WithdrawalLog log = (WithdrawalLog) getLog();
		boolean actionComplete = false;
		double balance;
		int amount;
		
		while(!actionComplete)
		{
			gui.displayAmounts();
			value = gui.getAmount();
			
			if(!session.verifySessionIntegrity()) break;
			
						
			
			if( value != "0")
			{
				amount = Integer.parseInt(value);
				
				if(cashManager.ensureAmountPermitted(amount))
				{
				balance = bank.getBalance(getAccountNumber());
				
				
				
				if(amount <= balance)
				{
					if(cashManager.isCashAvailable(amount))
					{
						cashManager.decrementCounters(amount);
						bank.decreaseBalance(getAccountNumber(), amount);
						gui.displaySuccesfulWithdrawMessage(amount);
						log.setAttributes(amount, (balance - amount));
						//log.writeLog();
						actionComplete = true;
					}
					else
					{
						gui.displayInsufCashATMMessage();
					}
					
				}
				else
				{
					gui.displayInsufCashAccMessage();
				}
				}
				else
				{
					gui.displayIllegalAmount();
				}
			}
			else
			{
				actionComplete = true;
			}
			
			}
				
		
		
		
		
		}
	
	
	public String getAccountNumber()
	{
		return super.getAccountNumber();	
		
	}

	
	
}
