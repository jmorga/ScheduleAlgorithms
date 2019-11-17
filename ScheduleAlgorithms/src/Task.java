
public class Task implements Comparable<Task> {

	private String name;
	private String algorithm;
	private int period;
	private int deadline;
	private int ETime;
	private int ETime_1188MHz;
	private int ETime_918MHz;
	private int ETime_648MHz;
	private int ETime_384MHz;
	private int priority;
	
	public Task(String name, int period, int deadline, int ETime_1188MHz, int ETime_918MHz, int ETime_648MHz, int ETime_384MHz, String algorithm)
	{
		this.name = name;
		this.period = period;
		this.deadline = deadline;
		this.ETime_1188MHz =ETime_1188MHz;
		this.ETime_918MHz = ETime_918MHz;
		this.ETime_648MHz = ETime_648MHz;
		this.ETime_384MHz = ETime_384MHz;
		this.algorithm = algorithm;
		
		switch(this.algorithm)
		{
			case "RM": this.priority = period; 
					   this.ETime = ETime_1188MHz; break;
			case "EDF": this.priority = deadline;
						this.ETime = ETime_1188MHz; break;
			default: this.priority = 0;
		}
	}
	
	public int compareTo(Task obj)
	{
		if(obj == null) return 0;
		
		return this.priority - obj.getPriority();
	}
	
	public int getFrequency()
	{
		int frequency = 0;
		switch(this.algorithm)
		{
			case "RM":
			case "EDF": frequency = 1188; break;
			
			default: frequency = 0;
		}
		
		return frequency;
	}
	
	public void ToString()// add condidtion for algoritm 
	{
		System.out.println(name + " " + period + " " + ETime_1188MHz + " " + ETime_918MHz + " "
				+ ETime_648MHz + " " + ETime_384MHz);
	}
	
	public String getName() { return this.name; }
	public int getPeriod() { return this.period; }
	public int getDeadline() { return this.deadline; }
	public int getPriority() { return this.priority; }
	public int getETime() { return this.ETime;}
	
	public int getETime_1188MHz() { return this.ETime_1188MHz; }
	public int getETime_918MHz() { return this.ETime_918MHz; }
	public int getETime_648MHz() { return this.ETime_648MHz; }
	public int getETime_384MHZ() { return this.ETime_384MHz; }
	
	public void setETime(int time) { this.ETime = time; }
	
	public Task getTask()
	{
		return new Task(this.name, this.period, this.deadline, this.ETime_1188MHz, this.ETime_918MHz, this.ETime_648MHz, this.ETime_384MHz, this.algorithm);
	}
}
