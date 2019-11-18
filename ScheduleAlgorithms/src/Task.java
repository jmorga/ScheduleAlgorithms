
public class Task implements Comparable<Task> {

	private String name;
	private String algorithm;
	private int period;
	private int deadline;
	private int ETime;
	private int setting;
	
	private int[] ETimes;
	private int priority;
	
	public Task(String name, int period, int deadline, int ETime_1188MHz, int ETime_918MHz, int ETime_648MHz, int ETime_384MHz, String algorithm)
	{
		this.name = name;
		this.period = period;
		this.deadline = deadline;
		this.ETimes = new int[4];
		this.ETimes[0] =ETime_1188MHz;
		this.ETimes[1] = ETime_918MHz;
		this.ETimes[2] = ETime_648MHz;
		this.ETimes[3] = ETime_384MHz;
		this.algorithm = algorithm;
		this.setting = -1;
		
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
		switch(setting)
		{
			case 0: frequency = 1188; break;
			case 1: frequency = 918; break;
			case 2: frequency = 648; break;
			case 3: frequency = 384; break;
			default: frequency = 1188;
		}
		
		return frequency;
	}
	
	public String getName() { return this.name; }
	public int getPeriod() { return this.period; }
	public int getDeadline() { return this.deadline; }
	public int getPriority() { return this.priority; }
	public int getETime() { return this.ETime;}
	
	public int[] getETimeArray() { return this.ETimes; }
	
	public void setETime(int time) { this.ETime = time; }
	
	public void setSetting(int setting) 
	{
		this.ETime = ETimes[setting];
		this.setting = setting;
	}
	
	public Task getTask()
	{
		Task tmp = new Task(this.name, this.period, this.deadline, this.ETimes[0], this.ETimes[1], this.ETimes[2], this.ETimes[3], this.algorithm);
		tmp.setETime(this.ETime);
		return tmp;
	}
	
	public String toString()// add condidtion for algoritm  
	{ 
		return (name + " " + period + " " + ETimes[0] + " " + ETimes[1] + " " 
				+ ETimes[2] + " " + ETimes[3]); 
	} 
	 
}
