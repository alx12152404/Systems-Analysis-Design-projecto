package bankSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {

	private static Bank bankInstance = null;
	private ArrayList<Account> accounts;
	Account manager = new Account("666","666", 200.00);
	String databaseType = readDataType();
	
	public Bank()
	{
		populateDatabase(databaseType);
	}
	
	public static Bank getBankInstance()
	{
		if(bankInstance == null)
		{
			bankInstance = new Bank();
		}
		return bankInstance;
	}
		
	public boolean authenticateUser(String enteredAccountNumber, String enteredPin) 
	{
		Account thisAccount = getAccount(enteredAccountNumber);
		
		if(thisAccount != null)
		{
			return thisAccount.validatePin(enteredPin);
		}
		else
		{
			return false;
		}				
	}
	
	public boolean verifyTargetAccount(String targetAccountNumber)
	{
		Account targetAccount = getAccount(targetAccountNumber);
		
		if(targetAccount != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Account getAccount(String accountNumber)
	{	
		for(int i = 0; i < accounts.size(); i++)
		{
			Account temp = accounts.get(i);
			
			if(temp.getAccountNumber().equals(accountNumber))
			{
				return temp;
			}
		}	
		return null;	
	}
	
	public double getBalance(String accountNumber)
	{
		return getAccount(accountNumber).getBalance();
	}
	
	public void increaseBalance(String accountNumber, double value)
	{
		getAccount(accountNumber).increaseBalance(value);
		FileManager fileManager = null;
		int amount = (int)value;
 		
 		switch(databaseType)
	    {
	        case "COMMA":
	        fileManager = new FileManagerComma();
	        break;
	        
	        case "TAB":
	        fileManager = new FileManagerTab();
	        break;
	       }
 		
 		fileManager.decreaseBalance(accountNumber, amount);
		
	}
	
	public void decreaseBalance(String accountNumber, double value)
	{
		getAccount(accountNumber).decreaseBalance(value);
		FileManager fileManager = null;
		int amount = (int)value;
 		
 		switch(databaseType)
	    {
	        case "COMMA":
	        fileManager = new FileManagerComma();
	        break;
	        
	        case "TAB":
	        fileManager = new FileManagerTab();
	        break;
	       }
 		
 		fileManager.decreaseBalance(accountNumber, amount);
 		
	}
	
	public void populateDatabase(String type)
	{
	    FileManager fileManager = null;
	    
	    switch(type)
	    {
	        case "COMMA":
	        fileManager = new FileManagerComma();
	        break;
	        
	        case "TAB":
	        fileManager = new FileManagerTab();
	        break;
	       }
	       
	         fileManager.populateBankDatabase();
	    
	    	 accounts = fileManager.accounts;        
             accounts.add(manager);
	}

	public static String readDataType() {
		{
	        String dbType = "";
	        String dbFile = "C:/Users/User/Documents/DatabaseType.txt";
	        try {
	        
	        FileReader fileReader = new FileReader(dbFile);  
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        dbType = bufferedReader.readLine();    
	        bufferedReader.close();
	       }
	       catch(FileNotFoundException ex) 
	        {
	            System.out.println(
	                "Unable to open file contained at: '" + dbFile + "'");                
	        } 
	        catch (IOException e) {
	        	
			e.printStackTrace();
		}
	        return dbType;
	    }
	}
}
