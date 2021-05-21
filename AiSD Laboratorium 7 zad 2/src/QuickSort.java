import java.util.Random;

// Sortowanie szybkie
public class QuickSort implements SortingAlgorithm
{
	// Generator liczb potrzebny do sortowania (z ustalonym seedem)
	Random random = new Random(1001);
	
	public QuickSort() {}
	
	public int[] sort(int[] array, int startIndex, int endIndex)
	{
		if (endIndex - startIndex > 1) {
			int partition = partition(array, startIndex, endIndex);
			sort(array, startIndex, partition );
			sort(array, partition + 1, endIndex);
			return array;
		}
		
		return array;
	}
	
	private int partition(int[] array, int nFrom, int nTo)
	{
		int rnd = nFrom + random.nextInt(nTo - nFrom);
		swap(array, nFrom, rnd);
		int value = array[nFrom];
		
		int idxBigger = nFrom + 1;
		int idxLower = nTo - 1;
		do 
		{
			while (idxBigger<=idxLower && array[idxBigger] <= value) 
			{
				idxBigger++;
			}
			
			while (array[idxLower] > value) 
			{
				idxLower --;
			}
			// Comparision to exit the loop
			
			if (idxBigger < idxLower) {
				swap(array, idxBigger, idxLower);
			}
			
		} while (idxBigger<idxLower);
		
		swap(array,idxLower,nFrom);
		
		return idxLower;
	}
	
	private void swap(int[] array, int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public String getNameOfSortingAlgorithm()
	{
		return "QuickSort";
	}
}