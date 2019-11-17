import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class main {

	public static void main(String[] args) 
	{
		
		
		
		 // The name of the file to open.
        String fileName = "input1.txt";

        // This will reference one line at a time
        String line = null;
        
        Task task1 = null;
        Task task2 = null;
	    Task task3 = null;
	    Task task4 = null;
	    Task task5 = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
           //Parses first line of input of input text
            String [] firstLineInput;
            int firstLineCounter = 0;
            //String array full of line one values ready to set vars
            firstLineInput = bufferedReader.readLine().split(" ");
        
           // 
	       

       
           String [] taskData;
           line = bufferedReader.readLine();
           
           int taskCount = 0;
           
           while (line != null) 
           {
        	   taskData = line.split(" ");
        	   String taskName = taskData[0];
               int deadline = Integer.parseInt(taskData[1]);
               int period = Integer.parseInt(taskData[1]);
               int ET1188 = Integer.parseInt(taskData[2]);
               int ET918 = Integer.parseInt(taskData[3]);
               int ET648 = Integer.parseInt(taskData[4]);
               int ET384 = Integer.parseInt(taskData[5]);

              for (String string : taskData) 
              {
				System.out.print(string + " ");
				
				
              }
              
              System.out.println();
               
               if(taskCount == 0)
               {
            	   task1 = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, "rm");
            	   //task1.ToString();
               }
               
               else if(taskCount == 1)
               {
            	   task2 = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, "rm");
               }
               
               else if(taskCount == 2)
               {
            	   task3 = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, "rm");
               }
               
               else if(taskCount == 3)
               {
            	   task4 = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, "rm");
               }
               
               else
               {
            	   task5 = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, "rm");

               }
               
               taskCount++;
               line = bufferedReader.readLine();
               
           }
           
        
            

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
    
        
        }
        
     task1.ToString();
     task2.ToString();
     task3.ToString();
     task4.ToString();
     task5.ToString();

       
        
        
	}

}
