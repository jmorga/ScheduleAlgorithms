
public class EDF {
	
	private int[] criticalPoints;
	private Task[] tasks;
	
	public EDF(Task[] tasks)
	{
		this.tasks = tasks;
		this.criticalPoints = new int[tasks.length];
		
		for(int i = 0; i < tasks.length; i++)
			this.criticalPoints[i] = tasks[i].getETime_1188MHz();
	}
	
	public String getSchedule()
	{
		return "The fucking Schedule";
	}
}
