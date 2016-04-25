
package bankSystem;

import java.util.ArrayList;


public abstract class FileManager {

//Account [] accounts = new Account[2];
ArrayList<Account> accounts = new ArrayList<Account>();


abstract public void populateBankDatabase();
} 
