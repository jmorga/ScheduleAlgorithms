import java.util.PriorityQueue;

public class RM_EDF {

	private Task[] tasks;
	private int[] periods;
	private PriorityQueue<Task> queue;
	
	public RM_EDF(Task[] tasks)
	{
		this.tasks = tasks;
		this.queue = new PriorityQueue<Task>();
		periods = new int[tasks.length];	
		
		for(int i = 0; i < tasks.length; i++)
			this.periods[i] = tasks[i].getPeriod();
	}
	
	public String getSchedule()
	{
		String schedule = "Start Time   Task Name   Frequency   Runtime   Energy\n";
		String name = "IDLE";
		String frequency = "IDLE";
		Task task = null;
		int lcm = this.getLeastCommonMultiple();
		int currentPeriod = 0;
		int lastPeriod = 0;
		int timeSegment = 0;
		int startTime = 0;
		int timer = 0;
		
		this.addTaskToQueue(currentPeriod);
		currentPeriod = this.getNextPeriod();
		timeSegment = currentPeriod - lastPeriod;
		
		while(timer < lcm)
		{
			task = queue.poll();
			startTime = timer;
			
			if(task == null)
			{
				name = "IDLE";
				frequency = "IDLE";
				timer += timeSegment;
				lastPeriod = currentPeriod;
				this.addTaskToQueue(currentPeriod);
				currentPeriod = this.getNextPeriod();
				timeSegment = currentPeriod - lastPeriod;
			}
			else if(task.getETime() < timeSegment)
			{
				name = task.getName();
				frequency = "" + task.getFrequency();
				
				timer += task.getETime();
				
				timeSegment -= task.getETime();
			}
			else
			{
				name = task.getName();
				frequency = "" + task.getFrequency();
				timer += timeSegment;
				task.setETime(task.getETime() - timeSegment);
				lastPeriod = currentPeriod;
				this.addTaskToQueue(currentPeriod);
				currentPeriod = this.getNextPeriod();
				this.queue.add(task.getTask());
				timeSegment = currentPeriod - lastPeriod;
			}
			
			schedule += this.getScheduleString(startTime, name, frequency, timer - startTime, 0);
		}
		
		return schedule;
	}
	
	private String getScheduleString(int StartTime, String taskName, String frequency, int runTime, int energy)
	{
		String space = "            ";
		
		return  StartTime + space.substring(("" + StartTime).length()-1) +
				taskName + space.substring(taskName.length()) +
				frequency + space.substring(("" + frequency).length()) +
		        runTime + space.substring(("" + runTime).length()) +
		        energy + "\n";
	}
	
	private void addTaskToQueue(int period)
	{
		for(int i = 0; i < tasks.length; i++)
			if(period % tasks[i].getPeriod() == 0) {
				this.queue.add(tasks[i].getTask());
			}
	}
	
	private int getNextPeriod()
	{
		int period= 1000000000;
		
		for(int i = 0 ; i < tasks.length; i++)
			if(periods[i] < period) {
				period = periods[i];
			}
		
		//updating critical points
		for(int i = 0 ; i < tasks.length; i++)
			if(periods[i] == period) {
				periods[i] += tasks[i].getPeriod();
			}
		
		return period;
	}
	
	public int getLeastCommonMultiple()
	{
		int lcm = 0;
		boolean notFound = true;
		
		for(int i = 0; i < tasks.length; i++)
			if(lcm < tasks[i].getPeriod())
				lcm = tasks[i].getPeriod();
		
		while(notFound)
		{
			notFound = false;
			for(int i = 0; i < periods.length; i++)
				if(lcm % periods[i] != 0)
					notFound = true;
			
			if(notFound) lcm++;
		}
		
		return lcm;
	}
}