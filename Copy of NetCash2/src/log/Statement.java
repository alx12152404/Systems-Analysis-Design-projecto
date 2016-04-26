package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Statement {
	
	private ArrayList<String> statement = new ArrayList<String>();
	
	public Statement(String accountNumber)
	{
		getLogs(accountNumber);	
	}
	
	public void getLogs(String accountNumber)
	{
        String fileName = "C:/Users/User/Documents/LOG" + accountNumber + ".txt";
        File file = new File(fileName);
        
        if(file.exists())
        {
		
		try {
			FileReader fileReader = new FileReader(fileName);    
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
			
				String line;
				int count = 0;
				

	            while((line = bufferedReader.readLine()) != null && count <10) 
	            {
	            	String logData[] = line.split(",");
	            	String currentLine = "";
	            	
	            	if(logData[1].equals("WITHDRAW"))
	            	{
	            	   currentLine = logData[0] + " " + logData[1] + " Amount: " + logData[2] + " Balance: " + logData[3];
	            	}
	            	else
	            	{
	            	   currentLine = logData[0] + " " + logData[1] + " Amount: " + logData[2] + " Balance: " + logData[3] + " Transfer Account: " + logData[4];
	            	}
	            	
	            	statement.add(currentLine);
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
		    catch (IOException e) 
		    {		
				e.printStackTrace();
			}
        }
		else
		{
			statement.add("No transactions to show.");
		}
	}
	
	public ArrayList<String> getStatement()
	{
		return this.statement;
	}
}