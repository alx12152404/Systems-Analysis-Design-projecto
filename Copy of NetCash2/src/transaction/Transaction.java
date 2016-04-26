package transaction;

import bankSystem.Bank;
import log.Log;
import session.Session;
import userInterface.GUI;

public abstract class Transaction {
	
	private String accountNumber;
	private GUI gui;
	private Bank bank;
	private Session session;
	private Log log;
	
	public Transaction(String accountNumber, GUI gui, Bank bank, Session session, Log log)
	{
		this.accountNumber = accountNumber;
		this.gui = gui;
		this.bank = bank;
		this.session = session;
		this.log = log;
	}
	
	abstract public void executeTransaction();
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public GUI getGUI()
	{
		return this.gui;
	}
	
	public Bank getBank()
	{
		return this.bank;
	}
	
	public Session getSession()
	{
		return this.session;
	}
	
	public Log getLog()
	{
		return this.log;
	}
}