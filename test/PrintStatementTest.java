package test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import log.Statement;



public class PrintStatementTest {

	@Test
	public void Case01TestShowPrintStatementPositive() {
		
		int i = 0;
		
		Object [] testArray = new Object[3] ; 
		testArray[0] = "25/04/2016 WITHDRAW Amount: 50.0 Balance: 150.0";
		testArray[1] = "25/04/2016 TRANSFER IN Amount: 50.0 Balance: 100.0 Transfer Account: 123456789";
		testArray[2] = "25/04/2016 TRANSFER OUT Amount: 20.0 Balance: 120.0 Transfer Account: 123456789";
		String testAccountNumber = "123456777";
		
		Statement statement1 = new Statement (testAccountNumber);
		ArrayList <String> statementAL = statement1.getStatement(); 
		
		Object [] statementArray = new Object [statementAL.size()] ;
		
		for (i = 0 ; i < statementAL.size() ; i++)
		{
			statementArray[i] = statementAL.get(i);
		}
		
		Assert.assertArrayEquals(null, statementArray , testArray);		
	}
	
	@Test
	public void Case02TestShowPrintStatementNegative() {

		int i = 0;
		
		Object [] testArray = new Object[1] ; 
		testArray[0] = "No transactions to show.";
		
		String testAccountNumber = "123456771";
		
		Statement statement1 = new Statement (testAccountNumber);
		ArrayList <String> statementAL = statement1.getStatement(); 
		
		Object [] statementArray = new Object [statementAL.size()] ;
		
		for (i = 0 ; i < statementAL.size() ; i++)
		{
			statementArray[i] = statementAL.get(i);
		}
		
		Assert.assertArrayEquals(null, statementArray , testArray);
			
	}
}