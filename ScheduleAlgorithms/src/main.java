import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;

public class main {

	public static void main(String[] args) 
	{
		
		
		
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



            
           numOfTask = Integer.parseInt(firstLineInput[0]);
           
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

              
               arrayOfTask[taskCount] = new Task(taskName, period, deadline, ET1188, ET918, ET648, ET384, "RM");

              
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
        
        
        
    //for (Task task : arrayOfTask) 
    //{

	//}
        for (int i : activePower) 
        {
			System.out.println(i);
		}
        
        Task[] array = new Task[3];
		
		array[0] = new Task("t1", 20, 20, 3, 0, 0, 0, "RM");
		array[1] = new Task("t2", 5, 5, 2, 0, 0, 0, "RM");
		array[2] = new Task("t3", 10, 10, 2, 0, 0, 0, "RM");
	
		RM rm = new RM(array);
		
		System.out.println(rm.getSchedule());
	}
}
