// Sortowanie przez scalanie
public class MergeSort implements SortingAlgorithm
{
	public MergeSort() {}
	
	public int[] sort(int[] array, int startIndex, int endIndex)
	{
		if (startIndex == endIndex) {
			int[] result = new int[1];
			result[0] = array[startIndex];
			return result;
		}
		
		// Splitting our array in half
		int splitIndex = startIndex + (endIndex - startIndex) / 2;
		
		return merge(sort(array, startIndex, splitIndex), sort(array, splitIndex + 1, endIndex));
	}
	
	private int[] merge(int[] leftArray, int[] rightArray)
	{
		// Our final array
		int[] result = new int[leftArray.length + rightArray.length];
		int indexOfResult = 0;
		
		// Initial indexes of first and second subarray
		int i = 0;
		int j = 0;
		
		// Iterating through subarrays till we create an end result
		while (i < leftArray.length && j < rightArray.length)
		{
			if (leftArray[i] <= rightArray[j]) {
				result[indexOfResult] = leftArray[i];
				i++;
			}
			
			else {
				result[indexOfResult] = rightArray[j];
				j++;
			}
			
			indexOfResult++;
		}
		
		// Adding the rest of our subarrays
		while (i < leftArray.length) 
		{
			result[indexOfResult] = leftArray[i];
			i++;
			indexOfResult++;
			
		}
		
		while (j < rightArray.length) 
		{
			result[indexOfResult] = rightArray[j];
			j++;
			indexOfResult++;
			
		}
		
		return result;
	}
	
	public String getNameOfSortingAlgorithm()
	{
		return "MergeSort";
	}
}
