import java.lang.Math;

public class EnergyEfficient {
	
	Task[] task;
	int[] activePower;
	int[][] power;
	double[][] ratio;
	
	double RMinequality;
	int EDFinequality = 1;
	
	public EnergyEfficient(Task[] task, int[] activePower)
	{
		this.task = task;
		this.activePower = activePower;
		this.power = new int[task.length][activePower.length];
		this.ratio = new double[task.length][activePower.length];
		this.RMinequality = ((double)task.length) * ( Math.pow(2.0, 1.0/((double)task.length)) - 1.0);
	}
	
	public void setDVFS()
	{
		this.calcPowerConsumedByTask();
		this.determineSlowingMakesSense();
		this.calculateRatio();
		
	}
	
	public Task[] getTasks() { return this.task; }

	private void calcPowerConsumedByTask()
	{
		for(int i = 0; i < task.length; i++)
			for(int k = 0; k < activePower.length; k++)
				power[i][k] = activePower[k] * task[i].getPeriod();
	}
	
	private void determineSlowingMakesSense()
	{
		int temp = 999999999;
		
		for(int i = 0; i < task.length; i++) 
		{
			for(int k = 0; k < activePower.length; k++) 
			{
				if(power[i][k] < temp)
					temp = power[i][k];
				else
					power[i][k] = -1;
			}
			temp = 999999999;
		}
	}
	
	private void calculateRatio()
	{
		for(int i = 0; i < task.length; i++)
			for(int k = 0; k < activePower.length; k++)
				if(power[i][k] > 0)
					ratio[i][k] = (double)task[i].getETimeArray()[k] / (double)task[i].getPeriod();
	}
	
	private void chooseValues()
	{
		
	}
	
	private void setTaskSettings()
	{
		
	}
	
}
