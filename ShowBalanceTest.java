package test;


import org.junit.Assert;
import org.junit.Test;

import bankSystem.Bank;



public class ShowBalanceTest {

	@Test
	public void Case01TestShowBalancePositive() {
		
		String testAccountNumber = "123456789";
		double testBalance = 223.00 ; 
		
		Bank bank = new Bank ();
		
		Assert.assertEquals(testBalance , bank.getBalance(testAccountNumber) , 0);
		
	}
	

}
