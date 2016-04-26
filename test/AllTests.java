package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LoginTest.class, PrintStatementTest.class,
		ShowBalanceTest.class, CashManagerTest.class })
public class AllTests {

}
