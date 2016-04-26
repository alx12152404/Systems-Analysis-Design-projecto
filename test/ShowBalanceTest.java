package test;


import org.junit.Assert;
import org.junit.Test;

import bankSystem.Bank;



public class ShowBalanceTest {

	@Test
	public void Case01TestShowBalancePositive() {
		
		String testAccountNumber = "123456777";
		double testBalance = 200.00 ; 	
		Bank bank = new Bank ();
		
		Assert.assertEquals(testBalance , bank.getBalance(testAccountNumber) , 0);
		
	}
}
