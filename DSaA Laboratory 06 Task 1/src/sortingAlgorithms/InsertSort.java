package sortingAlgorithms;

public class InsertSort implements SortingAlgorithm
{
	private int numberOfComparisions;
	private int numberOfAssignments;
	
	public InsertSort() 
	{
		numberOfComparisions = 0;
		numberOfAssignments = 0;
	}
	
	public int[] sort(int[] array)
	{
		// Calculating these numbers
		numberOfComparisions = 0;
		numberOfAssignments = 0;
		
		for (int i=1; i<array.length; i++)
		{
			int integer = array[i];
			int j = 0; 
			
			// Finding the place for our new person to fit into the already sorted part of the array
			for (j = i; j > 0 && integer < array[j-1]; j--)
			{
				numberOfComparisions ++;
				int swapInt = array[j-1];
				array[j-1] = array[j];
				array[j] = swapInt;
				numberOfAssignments += 3;
			}
			if (j != 0) {
				numberOfComparisions ++; // integer < array[j-1] returned false and that was our last comparision
			}
			
			
			// Fitting the person in the right spot in the already sorted array
			array[j] = integer;
			numberOfAssignments ++;
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
		return "Insertsort";
	}
}
