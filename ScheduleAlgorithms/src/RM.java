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
		String schedule = "Start Time   Task Name   Frequency   Runtime   Energy\n";
		Task task = null;
		int lcm = this.getLeastCommonMultiple();
		int currentPeriod = 0;
		int startTime = 0;
		int timer = 0;
		this.addTaskToQueue(currentPeriod);
		
		while(timer <= lcm)
		{
			task = queue.poll();
			startTime = timer + 1;
			
			if(task.getETime() < currentPeriod)
			{
				timer += task.getETime();
				currentPeriod -= task.getETime();
			}
			else
			{
				task.setETime(task.getETime() - currentPeriod);
				currentPeriod = this.getNextPeriod();
				this.addTaskToQueue(currentPeriod);
				this.queue.add(task.getTask());
			}
			
			schedule += this.getScheduleString(startTime, task.getName(), task.getFrequency(), startTime - timer, 0);
		}
		
		return schedule;
	}
	
	private String getScheduleString(int StartTime, String taskName, int frequency, int runTime, int energy)
	{
		String space = "            ";
		
		return  StartTime + space.substring(("" + StartTime).length()) +
				taskName + space.substring(taskName.length()) +
				frequency + space.substring(("" + frequency).length()) +
		        runTime + space.substring(("" + runTime).length()) +
		        energy + "\n";
	}
	
	private void addTaskToQueue(int period)
	{
		for(int i = 0; i < tasks.length; i++)
			if(period % tasks[i].getPeriod() == 0)
				this.queue.add(tasks[i].getTask());
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
	
	private int getLeastCommonMultiple()
	{
		int lcm = 0;
		int value = 0;
		boolean notFound = true;
		
		for(int i = 0; i < tasks.length; i++)
			if(lcm < tasks[i].getPeriod())
				lcm = tasks[i].getPeriod();
		
		value = lcm;
		while(notFound)
		{
			notFound = false;
			for(int i = 0; i < periods.length; i++)
				if(lcm % periods[i] != 0)
					notFound = true;
			
			if(notFound) lcm += value;
		}
		
		return lcm;
	}
}
