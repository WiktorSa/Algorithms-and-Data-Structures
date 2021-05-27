package sortingAlgorithms;

public class SelectSort implements SortingAlgorithm
{
	private int numberOfComparisions;
	private int numberOfAssignments;
	
	public SelectSort() 
	{
		numberOfComparisions = 0;
		numberOfAssignments = 0;
	}
	
	public int[] sort(int[] array)
	{
		// Calculating these numbers
		numberOfComparisions = 0;
		numberOfAssignments = 0;
		
		int n = array.length;
		  
        // Our goal is to find the minimum element of the array and move it to the front of 
        for (int i = 0; i < n-1; i++)
        {
        	// Assuming the minimal value is on this index
        	// If we find another value that is smaller than on this index we will change the index
            int minimalIndex = i;
            for (int j = i+1; j < n; j++)
            {
            	if (array[j] < array[minimalIndex]) {
            			minimalIndex = j;
            			numberOfComparisions ++; // Condition was true
            	}
            	numberOfComparisions ++; // Condition was false
            }
  
            // Swapping the minimal element with the first element of unsorted part of the array
            int swapInt = array[minimalIndex];
            array[minimalIndex] = array[i];
            array[i] = swapInt;
            
            numberOfAssignments += 3;
        }
		
		return array;
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
		return "SelectSort";
	}
}
