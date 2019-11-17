
import java.util.PriorityQueue;

public class Driver {

	public static void main(String[] args) 
	{
		PriorityQueue<Task> queue = new PriorityQueue<>();
		Task[] array = new Task[3];
		
		array[0] = new Task("t1", 20, 20, 3, 0, 0, 0, "RM");
		array[1] = new Task("t2", 5, 5, 2, 0, 0, 0, "RM");
		array[2] = new Task("t3", 10, 10, 2, 0, 0, 0, "RM");
	
		RM rm = new RM(array);
		
		System.out.println(rm.getSchedule());
	}
	
}
