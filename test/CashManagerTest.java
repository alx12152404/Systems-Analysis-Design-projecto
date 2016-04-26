package test;


import org.junit.Assert;
import org.junit.Test;

import atm.CashManager;

public class CashManagerTest {

	@Test
	public void Case01EnsureAmount5PermittedNegative() {
		
		CashManager cashManager = new CashManager ();
		
		Assert.assertFalse(cashManager.ensureAmountPermitted(5));
		
	}
	@Test
	public void Case02EnsureAmount10PermittedPositive() {
		
		CashManager cashManager = new CashManager ();
		
		Assert.assertTrue(cashManager.ensureAmountPermitted(10));
		
	}
	
	@Test
	public void Case03EnsureAmount20PermittedPositive() {
		
		CashManager cashManager = new CashManager ();
		
		Assert.assertTrue(cashManager.ensureAmountPermitted(20));
		
	}
	@Test
	public void Case04EnsureAmount50PermittedPositive() {
		
		CashManager cashManager = new CashManager ();
		
		Assert.assertTrue(cashManager.ensureAmountPermitted(50));
		
	}
	@Test
	public void Case05EnsureAmount100PermittedPositive() {
		
		CashManager cashManager = new CashManager ();
		
		Assert.assertTrue(cashManager.ensureAmountPermitted(100));
		
	}

	@Test
	public void Case06EnsureAmount200PermittedPositive() {
		
		CashManager cashManager = new CashManager ();
		
		Assert.assertTrue(cashManager.ensureAmountPermitted(200));
		
	}
	

}
