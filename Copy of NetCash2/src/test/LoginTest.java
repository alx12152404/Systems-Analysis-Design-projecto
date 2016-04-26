package test;

//import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;

import bankSystem.Bank;

public class LoginTest {

	@Test
	public void testLogin() 
	{
		String testAccountNumber = "123456789";
		String testPIN = "1234";
		Bank bank = new Bank();
		Assert.assertTrue(bank.authenticateUser(testAccountNumber, testPIN));
	}
}
