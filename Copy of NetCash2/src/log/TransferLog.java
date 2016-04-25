package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import userInterface.GUI;

public class TransferLog extends Log {
	
	private String targetAccountNumber;
	private double targetBalance;
	

	public TransferLog(String accountNumber, GUI gui) {
		super(accountNumber, gui);
	}

	@Override
	public void writeLog() {
		
		String fileName = "C:/Users/User/Documents/LOG" + this.getAccountNumber() + ".txt";
		String targetFileName = "C:/Users/User/Documents/LOG" + targetAccountNumber + ".txt";		

        try {
            
            FileWriter fileWriter = new FileWriter(fileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(formatDate(this.getTime()) + "," + "TRANSFER IN" + "," + this.getAmount() + 
            		                "," + this.getBalance()+ "," + targetAccountNumber);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
        
        try {
            
            FileWriter fileWriter = new FileWriter(targetFileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(formatDate(this.getTime()) + "," + "TRANSFER OUT" + "," + this.getAmount() 
                                                            + "," + targetBalance + "," + this.getAccountNumber());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + targetFileName + "'");
        }
        
        
	}
	
	/*public String getTargetAccountNumber()
	{
		return this.targetAccountNumber;
	}
	
	public double getTargetBalance()
	{
		return this.targetBalance;
	} */
	
	public void setAttributes(double amount, double balance, String targetAccountNumber, double targetBalance)
	{

		Date currentTime = new Date();
		this.setTime(currentTime);
		this.setAmount(amount);
		this.setBalance(balance);
		this.targetAccountNumber = targetAccountNumber;
		this.targetBalance = targetBalance;
	}
	
	


}
