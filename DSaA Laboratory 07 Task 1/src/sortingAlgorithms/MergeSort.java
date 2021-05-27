package sortingAlgorithms;

public class MergeSort implements SortingAlgorithm
{
	private int numberOfComparisions;
	private int numberOfAssignments;
	
	public MergeSort() 
	{
		numberOfComparisions = 0;
		numberOfAssignments = 0;
	}
	
	public int[] sort(int[] array, int startIndex, int endIndex)
	{
		if (startIndex == endIndex) {
			int[] result = new int[1];
			result[0] = array[startIndex];
			numberOfAssignments++;
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
				numberOfAssignments++;
			}
			
			else {
				result[indexOfResult] = rightArray[j];
				j++;
				numberOfAssignments++;
			}
			
			indexOfResult++;
			numberOfComparisions++;
		}
		
		// Adding the rest of our subarrays
		while (i < leftArray.length) 
		{
			result[indexOfResult] = leftArray[i];
			i++;
			indexOfResult++;
			
			numberOfAssignments++;
		}
		
		while (j < rightArray.length) 
		{
			result[indexOfResult] = rightArray[j];
			j++;
			indexOfResult++;
			
			numberOfAssignments++;
		}
		
		return result;
	}
	
	// We need to reset our results in separate function
	// Because sorting function is too complex to reset it there
	public void resetData()
	{
		numberOfAssignments = 0;
		numberOfComparisions = 0;
	}

	public int getNumberOfComparisions() 
	{
		return numberOfComparisions;
	}

	public void setNumberOfComparisions(int numberOfComparisions) 
	{
		this.numberOfComparisions = numberOfComparisions;
	}

	public int getNumberOfAssignments() 
	{
		return numberOfAssignments;
	}

	public void setNumberOfAssignments(int numberOfAssignments) 
	{
		this.numberOfAssignments = numberOfAssignments;
	}
	
	public String getNameOfSortingAlgorithm()
	{
		return "MergeSort";
	}
}
