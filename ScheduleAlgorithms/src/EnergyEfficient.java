import java.lang.Math;

public class EnergyEfficient {
	
	Task[] task;
	int[] activePower;
	int[] settings;
	int[][] power;
	double[][] ratio;
	
	double inequality;
	
	public EnergyEfficient(Task[] task, int[] activePower, String algorithm)
	{
		this.task = task;
		this.activePower = activePower;
		this.power = new int[task.length][activePower.length];
		this.ratio = new double[task.length][activePower.length];
		this.settings = new int[task.length];
		
		if(algorithm.equalsIgnoreCase("RM"))
			inequality = ((double)task.length) * ( Math.pow(2.0, 1.0/((double)task.length)) - 1.0);
		else
			inequality = 1;
	}
	
	public void setDVFS()
	{
		this.calcPowerConsumedByTask();
		this.determineSlowingMakesSense();
		this.calculateRatio();
		this.chooseValues();
		this.setTaskSettings();
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
		double value = 0;
		double temp = 0;
		
		for(int i = 0; i < activePower.length; i++) 
			for(int k = 0; k < activePower.length; k++) 
				for(int j = 0; j < activePower.length; j++) 
					for(int x = 0; x < activePower.length; x++) 
						for(int y = 0; y < activePower.length; y++) {
							temp = ratio[0][i] + ratio[1][k] + ratio[2][j] + ratio[3][x] + ratio[4][y];
							
							if((temp > value) && (temp <= inequality)) {
								value = temp;
								settings[0] = i;
								settings[1] = k;
								settings[2] = j;
								settings[3] = x;
								settings[4] = y;
							}
						}
	}
	
	private void setTaskSettings()
	{
		for(int i = 0; i < task.length; i++)
			task[i].setSetting(settings[i]);
	}
	
}
