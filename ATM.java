package atm;

import bankSystem.*;
import log.*;
import session.Session;
import transaction.*;
import userInterface.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

public class ATM {
    
    private boolean userAuthenticated;
    private String currentAccountNumber;
    private GUI gui;
    private Bank bank;
    private Log log;
    private Session session;
    private CashManager cashManager;
    
    public ATM()
    {
        userAuthenticated = false;
        currentAccountNumber = "";
        gui = new GUI();
        bank = new Bank();
        cashManager = new CashManager();
        
    }
    
    public static void main(String[]args)
    {
        ATM atm = new ATM();
        atm.run();
    }
    
    public void run()
    {
        while(true)
        {
            while(!userAuthenticated)
            {
                session = new Session();
                gui.displayWelcome();
                
                authenticateUser();
                
                if(!session.verifySessionIntegrity())
                {
                    userAuthenticated = false;
                }
                
            }
            if(currentAccountNumber.equals("666"))
            {
                managerMenu();               
            }
            else
            {
                mainMenu();
               userAuthenticated = false;
               currentAccountNumber = "";
            }
        }
    }
    
    
    private void mainMenu() {
        
        boolean userExited = false;
        String selection;
        Transaction transaction = null;
        
        
        
        while(!userExited && session.getIsSessionActive())
        {
                        
            gui.displaySelection();
            selection = gui.getSelection();
                       
            
            if(!session.verifySessionIntegrity()) 
                {
                   break;
                }
            
            switch(selection)
            {
               case "1":
               case "2":
                   
                   transaction = newTransaction(selection);
                   transaction.executeTransaction();
                   log.writeLog();
                   break;
                   
               case "3":
                    
                    gui.displayBalance(getBalance());
                    break;
                    
               case "4":
                    Statement statement = new Statement(currentAccountNumber);
                    gui.displayStatement(statement.getStatement());
                    break;
                   
               case "5":
                   
                   gui.displayExitMessage();
                   userExited = true;
                   break;
                   
               default:
                   
                   gui.displayInvalidSelection();
                   break;
                            
            }
            
        }
        
    }
    
    private void managerMenu() {
        String selection;
        boolean userExited = false;
        
       while(!userExited && session.getIsSessionActive())
        {
         
         gui.displayManagerSelection();
         selection = gui.getSelection();
         File  dbFile = new File ("H:/College/CS4125/NetCash2/DatabaseType.txt");
        
            switch(selection)
            {
               case "1":
               
               //File  dbFile = new File ("H:/College/CS4125/NetCash2/DatabaseType.txt");
               dbFile.delete();
               
               try {
               FileWriter f1 = new FileWriter(dbFile, false);
               f1.write("COMMA");
               f1.close();
               } catch (IOException ex) {
                 
               }
               System.out.println("Data is now comma seperated");
               break;
                
               
               case "2":
               //File  dbFile = new File ("H:/College/CS4125/NetCash2/DatabaseType.txt");
               dbFile.delete();
               
               try {
               FileWriter f1 = new FileWriter(dbFile, false);
               f1.write("TAB");
               f1.close();
               } catch (IOException ex) {
                 
               }
               System.out.println("Data is now tab seperated");
               break;
               
               case "3":
               
               gui.displayExitMessage();
               userExited = true;
               break;
                                            
            }
        }
    
}

/*  private Statement getStatement() {
        
        return currentAccountNumber;
        // TODO Auto-generated method stub
        
    }

*/
    private Transaction newTransaction(String selection) {
        // TODO Auto-generated method stub
        
        Transaction transaction = null;
        
        switch(selection)
        {
        case "1":
            
            log = new WithdrawalLog(currentAccountNumber, gui);
            transaction = new Withdrawal(currentAccountNumber, gui, bank, session, log, cashManager);
            break;
            
        case "2":
            
            log = new TransferLog(currentAccountNumber, gui);
            transaction = new Transfer(currentAccountNumber, gui, bank, session, log);
            break;
                    
            
        }
        
        return transaction;
        
    }
    
    private double getBalance()
    {
        return bank.getBalance(currentAccountNumber);
    }

    private void authenticateUser() {
        
        String enteredAccountNumber = gui.getAccountNumber();
        String enteredPin = gui.getPin();
        userAuthenticated = bank.authenticateUser(enteredAccountNumber, enteredPin);
        
        if(userAuthenticated)
        {
            currentAccountNumber = enteredAccountNumber;
            System.out.print(currentAccountNumber);
        }
        else
        {
            gui.displayInvalidCredentialsMessage();
        }
                
        
    }
    
    
    

}
