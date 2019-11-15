import java.util.PriorityQueue;

public class RM {

	private Task[] tasks;
	private int[] periods;
	private PriorityQueue<Task> queue;
	
	public RM(Task[] tasks)
	{
		this.tasks = tasks;
		this.queue = new PriorityQueue<Task>();
		
		periods = new int[tasks.length];	
		
		for(int i = 0; i < tasks.length; i++)
			this.periods[i] = tasks[i].getPeriod();
	}
	
	public String getSchedule()
	{
		String schedule = "Time Started  Task Name  ";
		int period = 0;
		
		//All tasks arrive at time 0
		for(int i = 0; i < this.tasks.length; i++)
			this.queue.add(tasks[i]);
		
	    period = getNextPeriod();
		
		return "the fucking schedule";
	}
	
	private String getScheduleString(int StartTime, String taskName, int frequency, int runTime, int energy)
	{
		return  StartTime + "	" + "";
	}
	
	private int getNextPeriod()
	{
		int period= -1;
		int index = 0;
		
		for(int i = 0 ; i < tasks.length; i++)
			if(periods[i] > period) {
				period = periods[i];
				index = i;
			}
		
		//updating critical points
		periods[index] += tasks[index].getPeriod();
		
		return period;
	}
}
