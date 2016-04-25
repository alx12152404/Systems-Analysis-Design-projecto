package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import userInterface.GUI;

public class WithdrawalLog extends Log {

	public WithdrawalLog(String accountNumber, GUI gui) {
		super(accountNumber, gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeLog() {
		
		String fileName = "C:/Users/User/Documents/LOG" + this.getAccountNumber() + ".txt";

        try {
            
            FileWriter fileWriter = new FileWriter(fileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(formatDate(this.getTime()) + "," +"WITHDRAW" + "," + "," + this.getAmount() + "," + this.getBalance());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
		
		
	}
	
	
	public void setAttributes(double amount, double balance)
	{

		Date currentTime = new Date();
		this.setTime(currentTime);
		this.setAmount(amount);
		this.setBalance(balance);
	}

	
	

}
