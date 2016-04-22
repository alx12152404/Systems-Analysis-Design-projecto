package test;

//import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import log.Log;
import log.WithdrawalLog;

import org.junit.Assert;
import org.junit.Test;

import atm.CashManager;
import bankSystem.Bank;
import session.Session;
import transaction.Transaction;
import transaction.Withdrawal;
import userInterface.GUI;
import java.io.InputStream;


public class WithdrawTest {

	@Test
	public void testWithdrawal() {
		
		String testAccountNumber = "123456789";
		Bank bank = new Bank();
		Session session = new Session ();
		GUI gui = new GUI();
		CashManager cashManager = new CashManager();
		WithdrawalLog log = new WithdrawalLog(testAccountNumber , gui);
		
		Withdrawal withdrawal = new Withdrawal (testAccountNumber, gui , bank , session , log , cashManager);
		
		withdrawal.executeTransaction();
		
		String data = "45";
		InputStream stdin = System.in;
		try {
		  System.setIn(new ByteArrayInputStream(data.getBytes()));
		  Scanner scanner = new Scanner(System.in);
		  System.out.println(scanner.nextLine());
		} finally {
		  System.setIn(stdin);
		}
		
		
	}

}
