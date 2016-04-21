package bankSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bank {

	//private static Bank bankInstance = null;
	private Account [] accounts;
	
	public Bank()
	{
		accounts = new Account[sizeOfDatabase()];
		populateDatabase();
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
		
		for(int i = 0; i < accounts.length; i++)
		{
			Account temp = accounts[i];
	
			
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
	
	public void populateDatabase()
	{

		String fileName = "C:/Users/User/Documents/BankDatabase.txt";
		
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
		
	}
}
