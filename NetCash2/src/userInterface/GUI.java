package userInterface;

import java.util.Scanner;

import log.Log;

public class GUI {
	
	private Scanner scanner;
	
	public GUI()
	{
		scanner = new Scanner(System.in);
	}

	public void displayWelcome() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to this NetCash ATM!");
		
	}

	public String getAccountNumber() {
		//TODO Auto-generated method stub
		System.out.print("Enter your Account Number: ");
		return scanner.next();
		
	}

	public String getPin() {
		// TODO Auto-generated method stub
		System.out.print("Enter your PIN: ");
		return scanner.next();
		
		
	}

	public void displayInvalidCredentialsMessage() {
		// TODO Auto-generated method stub
		System.out.println("invalid credentials");
		
	}

	public String getSelection() {
		
		return scanner.next();
		
	}

	public void displaySelection() {
		// TODO Auto-generated method stub
		System.out.println("Enter the name of the action you wish to perform. \n\n"
				         + "Permitted actions are:");
		System.out.println("              1-WITHDRAW");
		System.out.println("              2-TRANSFER");
		System.out.println("              3-SHOW BALANCE");
		System.out.println("              4-PRINT STATEMENT");
		System.out.println("              5-EXIT");		
	}

	public String getAmount() {
		// TODO Auto-generated method stub
		return scanner.next();
	}

	public void displayAmounts() {
		// TODO Auto-generated method stub
		System.out.println("Please enter the amount you would like to withdraw. \n\n"
				         + "Permitted values are:");
		System.out.println("10");
		System.out.println("20");
		System.out.println("50");
		System.out.println("100");
		System.out.println("200");
		System.out.println("0-EXIT");
		
		
	}

	public void displaySuccesfulWithdrawMessage(double amount) {
		// TODO Auto-generated method stub
		System.out.println("You have withdrawn £" + amount + " from your account");
		
	}

	public void displayInsufCashATMMessage() {
		// TODO Auto-generated method stub
		System.out.println("Insufficient cash in this ATM");
		
	}

	public void displayInsufCashAccMessage() {
		// TODO Auto-generated method stub
		System.out.println("Insufficient cash in your account");
		
	}

	public void displayExitMessage() {
		// TODO Auto-generated method stub
		
	}

	public void displayInvalidSelection() {
		// TODO Auto-generated method stub
		
	}

	public String getTransferAccountNumber() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Account Number of the Account you want to transfer to: ");
		return scanner.next();
		
		
	}
	
	public void displayBalance(double balance)
	{
		System.out.println("Your current account balance is: " + balance);
	}

	public String getTransferAmount() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Amount you want to transfer or enter EXIT to cancel: ");
		return scanner.next();
	}

	public void displayNoAccount() {
		// TODO Auto-generated method stub
		System.out.println("Invalid Account Number. Try again.");
		
	}

	public void displaySuccesfulTransferMessage(String targetAccountNumber, double amount) {
		// TODO Auto-generated method stub
		System.out.println("You have Transfered £" + amount + " to Account " + targetAccountNumber);
		
	}
	
	public void displayWithdrawLog(Log log)
	{
		System.out.println("LOG:: ACCOUNT NUMBER: " + log.getAccountNumber() + " TIME: " + log.getTime() + " AMOUNT: " + log.getAmount() + " BALANCE: " + log.getBalance());
		
	}

	public void displayIllegalAmount() {
		// TODO Auto-generated method stub
		System.out.println("Amount selected is not peritted");
		
	}

	public void displayStatement(String statement) {
		// TODO Auto-generated method stub
		System.out.println("Statement: \n" + statement);
	}

	/*public void displayTransferLog(TransferLog transferLog) {
		// TODO Auto-generated method stub
		System.out.println("LOG:: ACCOUNT NUMBER: " + transferLog.getAccountNumber() + " TIME: " + transferLog.getTime() + " AMOUNT: " + transferLog.getAmount() 
		                        + " BALANCE: " + transferLog.getBalance() + " TARGET ACCOUNT: " + transferLog.getTargetAccountNumber() + " TARGET BALANCE: " + transferLog.getTargetBalance());
	}
	*/








}
