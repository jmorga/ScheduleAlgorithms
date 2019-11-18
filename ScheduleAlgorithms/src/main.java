import java.awt.image.FilteredImageSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception 
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to our scheduler. Please input the schdeulinging algortihm you want to invoke: \n"
				+ "Either RM, EDF");
		
		String algor = keyboard.nextLine();
		
		System.out.println("Would you like it to be energy efficient? Type Y for yes or N for no: ");
		
		String EE = keyboard.nextLine();
		
		int idlePower = 0;
		int amountOfTimeToEXecute = 0;
		
		 // The name of the file to open.
        String fileName1 = "input1.txt";
        String fileName2 = "input2.txt";

        // This will reference one line at a time
        String line = null;
        
        Task [] arrayOfTask = null;
        int [] activePower = new  int[4];

	    int numOfTask = 0;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName1);

            // Always wrap FileReader in BufferedReader.
           BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
           //Parses first line of input of input text
           String [] firstLineInput;
           //String array full of line one values ready to set vars
           firstLineInput = bufferedReader.readLine().split(" ");
           
          
           activePower[0] = Integer.parseInt(firstLineInput[2]); 
           activePower[1] = Integer.parseInt(firstLineInput[3]); 
           activePower[2] = Integer.parseInt(firstLineInput[4]); 
           activePower[3] = Integer.parseInt(firstLineInput[5]); 



           idlePower = Integer.parseInt(firstLineInput[6]);
           numOfTask = Integer.parseInt(firstLineInput[0]);
           amountOfTimeToEXecute = Integer.parseInt(firstLineInput[1]);
           
           arrayOfTask = new Task[numOfTask];
           
           // 

           String [] taskData;
           line = bufferedReader.readLine();
           
           int taskCount = 0;
           
           while (line != null && taskCount < arrayOfTask.length) 
           {
        	   taskData = line.split(" ");
        	   String taskName = taskData[0];
               int deadline = Integer.parseInt(taskData[1]);
               int period = Integer.parseInt(taskData[1]);
               int ET1188 = Integer.parseInt(taskData[2]);
               int ET918 = Integer.parseInt(taskData[3]);
               int ET648 = Integer.parseInt(taskData[4]);
               int ET384 = Integer.parseInt(taskData[5]);

              
               arrayOfTask[taskCount] = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, algor);

              
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
                fileName1 + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println(
                "Error reading file '" 
                + fileName1 + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
    
        
        }
        
        
        if(EE.equalsIgnoreCase("Y"))
        {
        	EnergyEfficient test2 = new EnergyEfficient(arrayOfTask, activePower, algor);
        	test2.setDVFS();
        	arrayOfTask = test2.getTasks();
        }
        
        RM_EDF test1 = new RM_EDF(arrayOfTask, idlePower);
        
        test1.setTimeToExecute(amountOfTimeToEXecute);
        
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(test1.getSchedule());
         
        writer.close();
        
        
        
        
        
       
        
  
		
		
		

		
	}
}
