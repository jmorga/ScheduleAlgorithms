
public class BubbleSort {
	
	public void bubbleSort(int[] array)
	{
		boolean flag = true;
		
		while(flag)
		{
			flag = false;     //Set to false to exit loop in case there is no swap
			
			for(int i = 0; i < array.length - 1; i++)
				if(array[i] > array[i + 1])
				{
					swap(array, i, i + 1);
					flag = true;           //Set to true to iterate again
				}
		}
	}
	
	private void swap(int[] array, int x, int y)
	{
		int hold = array[x];
		
		array[x] = array[y];
		array[y] = hold;
	}
}
