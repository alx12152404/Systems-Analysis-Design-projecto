package bankSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {

	//private static Bank bankInstance = null;
	//private Account [] accounts;
	private ArrayList<Account> accounts;
	String databaseType = "COMMA";
	
	public Bank()
	{
		//accounts = new Account[sizeOfDatabase()];

		populateDatabase(databaseType);
	}
	
	/*public static Bank getBankInstance()
	{
		if(bankInstance == null)
		{
			bankInstance = new Bank();
		}
		return bankInstance;
	}
	*/
	
	
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
		FileManagerComma fileManagerComma = new FileManagerComma();
		int amount = (int)value;
 		fileManagerComma.increaseBalance(accountNumber, amount);
		
	}
	
	public void decreaseBalance(String accountNumber, double value)
	{
		getAccount(accountNumber).decreaseBalance(value);
	}
	
	public int sizeOfDatabase()
	{
	    
		int count = 0;
		String fileName = "C:/Users/User/Documents/BankDatabase.txt";
				
		 try {
	            FileReader fileReader = new FileReader(fileName);
	          
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            while((bufferedReader.readLine()) != null) 
	            {
                     count++;
	            }   

	            
	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) 
		    {
	            System.out.println(
	                "Unable to open file contained at: '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) 
		    {
	        }
		 return count;

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
	        
	     for(int i = 0; i < sizeOfDatabase(); i++)
		{

	    	 accounts = fileManager.accounts;
			//accounts.add(fileManager.accounts.get(i));
	        
		}
	    
	    
	    
	    
	    
	    
	    /*
	    
	    
		String fileName = "C:/Users/c12161578/Desktop/BankDatabase.txt";
		
		try {
		FileReader fileReader = new FileReader(fileName);    
        BufferedReader bufferedReader = new BufferedReader(fileReader);
		
			String line;
			int i = 0;

            while((line = bufferedReader.readLine()) != null) 
            {
            	String accountData[] = line.split(", "); 	
            	double accountBalance = Double.parseDouble(accountData[2]);
            	accounts[i] = new Account(accountData[0], accountData[1], accountBalance);
            	i++;
            }  
		
		bufferedReader.close();
		}
		catch(FileNotFoundException ex) 
	    {
            System.out.println(
                "Unable to open file contained at: '" + 
                fileName + "'");                
        }
        catch(IOException ex) 
	    {
        }
        */
		
	}
}
