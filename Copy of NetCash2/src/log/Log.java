package log;

import java.text.SimpleDateFormat;
import java.util.Date;

import userInterface.GUI;

public abstract class Log {
	
	private Date time;
	private String accountNumber;
	private double amount;
	private double balance;
	private GUI gui;
	
	Log(String accountNumber, GUI gui)
	{	
		this.accountNumber = accountNumber;
		this.gui = gui;		
	}
	
	abstract public void writeLog();
	
	public String formatDate(Date time)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(time);
	}
	
	
	public Date getTime()
	{
		return this.time;
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public Double getAmount()
	{
		return this.amount;
	}
	
	public Double getBalance()
	{
		return this.balance;
	}
	
	public GUI getGUI()
	{
		return this.gui;
	}
	
	public void setTime(Date time)
	{
		this.time = time;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
}