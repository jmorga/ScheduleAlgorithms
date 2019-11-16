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
		
		String [] firstLineInput;
		 // The name of the file to open.
        String fileName = "input1.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            firstLineInput = bufferedReader.readLine().split(" ");
            
            for (String string : firstLineInput) 
            {
				System.out.print(string+ " ");
			}
            
            

//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }   

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
        
        
	}

}
