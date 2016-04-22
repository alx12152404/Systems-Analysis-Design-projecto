package test;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import bankSystem.Bank;

public class LoginTest {

	@Test
	public void testLogin() {
		String testAccountNumber = "123456789" ; 
		String testPin = "1234" ; 
		Bank bank = new Bank ();
		Assert.assertTrue(bank.authenticateUser(testAccountNumber, testPin));
	}
	@Test
	public void case02LoginNegative() {
		String testAccountNumber = "323456789" ; 
		String testPin = "1234" ; 
		Bank bank = new Bank ();
		Assert.assertFalse(bank.authenticateUser(testAccountNumber, testPin));
	}
	@Test
	public void case03LoginNegative() {
		String testAccountNumber = "123456789" ; 
		String testPin = "2224" ; 
		Bank bank = new Bank ();
		Assert.assertFalse(bank.authenticateUser(testAccountNumber, testPin));
	}
	@Test
	public void case04LoginNegative() {
		String testAccountNumber = "333456789" ; 
		String testPin = "2224" ; 
		Bank bank = new Bank ();
		Assert.assertFalse(bank.authenticateUser(testAccountNumber, testPin));
	}

}
