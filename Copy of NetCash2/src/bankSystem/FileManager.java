
package bankSystem;

import java.util.ArrayList;


public abstract class FileManager {

ArrayList<Account> accounts = new ArrayList<Account>();


abstract public void populateBankDatabase();
abstract public void decreaseBalance(String accountNumber, double amount);
abstract public void increaseBalance(String accountNumber, double amount);
} 
