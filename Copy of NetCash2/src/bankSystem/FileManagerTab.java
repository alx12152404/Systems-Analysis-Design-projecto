package bankSystem;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class FileManagerTab extends FileManager
{

    public void populateBankDatabase()
    {
        
        String fileName = "C:/Users/User/Documents/BankDatabaseTab.txt";
        
        try {
        FileReader fileReader = new FileReader(fileName);    
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
            
            while((line = bufferedReader.readLine()) != null) 
            {
                String accountData[] = line.split("       ");     
                double accountBalance = Double.parseDouble(accountData[2]);
                accounts.add(new Account(accountData[0], accountData[1], accountBalance));
                
            }  
        
        bufferedReader.close();
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println(
                "Unable to open file contained at: '" + 
                fileName + "'");                
        }
        catch(IOException ex) 
        {
        }
    }
    
    public void increaseBalance(String accountNumber, double amount)
    {
        ArrayList<String> lines = new ArrayList<String>();
        String fileName = "C:/Users/User/Documents/BankDatabaseTab.txt";
        BufferedReader in;
        
        try {
        in = new BufferedReader(new FileReader(fileName));
        
        String line = in.readLine();
        while (line != null) 
        {
            if (line.startsWith(accountNumber)) {
                String accountData[] = line.split("       ");     
                double oldBalance = Double.parseDouble(accountData[2]);
                double newBalance = oldBalance + amount;
                line = accountNumber + "       " + accountData[1] + "       " + newBalance;
            }
            lines.add(line);
            line = in.readLine();
        }
        in.close();

        PrintWriter out = new PrintWriter(fileName);
        for (String l : lines)
            out.println(l);
            out.close();    
        
        } 
        catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    
    public void decreaseBalance(String accountNumber, double amount)
    {
        ArrayList<String> lines = new ArrayList<String>();
        String fileName = "C:/Users/User/Documents/BankDatabaseTab.txt";

        BufferedReader in;
        try {
        in = new BufferedReader(new FileReader(fileName));
        
        String line = in.readLine();
        while (line != null) 
        {
            if (line.startsWith(accountNumber)) 
            {
                String accountData[] = line.split("       ");     
                double oldBalance = Double.parseDouble(accountData[2]);
                double newBalance = oldBalance - amount;      
                line = accountNumber + "       " + accountData[1] + "       " + newBalance;
            }
            lines.add(line);
            line = in.readLine();
        }
        in.close();

        PrintWriter out = new PrintWriter(fileName);
        
        for (String l : lines)
            out.println(l);
            out.close();    
        
        } catch (IOException e) {
         
            e.printStackTrace();
        }
    }
   
}