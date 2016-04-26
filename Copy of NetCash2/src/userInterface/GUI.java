package userInterface;

import java.util.ArrayList;
import java.util.Scanner;


public class GUI {
	
	private Scanner scanner;
	
	public GUI()
	{
		scanner = new Scanner(System.in);
	}

	public void displayWelcome() {
		
		System.out.println("Welcome to this NetCash ATM!");		
	}

	public String getAccountNumber() {
		
		System.out.print("Enter your Account Number: ");
		return scanner.next();		
	}

	public String getPin() {
		
		System.out.print("Enter your PIN: ");
		return scanner.next();		
	}

	public void displayInvalidCredentialsMessage() {

		System.out.println("invalid credentials");	
	}

	public String getSelection() {
		
		return scanner.next();	
	}

	public void displaySelection() {
		System.out.println("Enter the name of the action you wish to perform. \n\n"
				         + "Permitted actions are:");
		System.out.println("              1-WITHDRAW");
		System.out.println("              2-TRANSFER");
		System.out.println("              3-SHOW BALANCE");
		System.out.println("              4-PRINT STATEMENT");
		System.out.println("              5-EXIT");		
	}
	
	public void displayManagerSelection(String dbType){
	         
        System.out.println("Currently data is stored using "+ dbType +"'s \n\n"
                         + "Change storage type to");
        System.out.println("              1-COMMA");
        System.out.println("              2-TAB");   
    }

	public String getAmount() {
		
		return scanner.next();
	}

	public void displayAmounts() {
		
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

		System.out.println("You have withdrawn £" + amount + " from your account");
		
	}

	public void displayInsufCashATMMessage() {
	
		System.out.println("Insufficient cash in this ATM");
		
	}

	public void displayInsufCashAccMessage() {
	
		System.out.println("Insufficient cash in your account");
		
	}

	public void displayInvalidSelection() {
		
		System.out.println("Invalid selection");
		
	}

	public String getTransferAccountNumber() {
		
		System.out.print("Enter the Account Number of the Account you want to transfer to: ");
		return scanner.next();
		
		
	}
	
	public void displayBalance(double balance)
	{
		System.out.println("Your current account balance is: " + balance);
	}

	public String getTransferAmount() {
		
		System.out.print("Enter the Amount you want to transfer or enter EXIT to cancel: ");
		return scanner.next();
	}

	public void displayNoAccount() {
		
		System.out.println("Invalid Account Number. Try again.");
		
	}

	public void displaySuccesfulTransferMessage(String targetAccountNumber, double amount) {
	
		System.out.println("You have Transfered £" + amount + " to Account " + targetAccountNumber);
		
	}

	public void displayIllegalAmount() {

		System.out.println("Amount selected is not peritted");
		
	}

	public void displayStatement(ArrayList<String> statement) {

		System.out.println("Statement:");
		
		for(int i = 0; i < statement.size(); i++)
		{
			System.out.println("      " + statement.get(i));
		}
	}
}
