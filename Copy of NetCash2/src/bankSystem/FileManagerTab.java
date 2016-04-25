package bankSystem;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileManagerTab extends FileManager
{

    public void populateBankDatabase()
    {
        
        String fileName = "H:/College/CS4125/GitHubFiles/BankDatabase.txt";
        
        try {
        FileReader fileReader = new FileReader(fileName);    
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
            String line;
            

            while((line = bufferedReader.readLine()) != null) 
            {
                String accountData[] = line.split(" ");     
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
   
}

