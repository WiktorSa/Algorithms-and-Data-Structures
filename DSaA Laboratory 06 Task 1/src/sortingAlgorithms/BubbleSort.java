package sortingAlgorithms;

public class BubbleSort implements SortingAlgorithm
{
	private int numberOfComparisions;
	private int numberOfAssignments;
	
	public BubbleSort() 
	{
		numberOfComparisions = 0;
		numberOfAssignments = 0;
	}
	
	public int[] sort(int[] array)
	{
		// Calculating these numbers
		numberOfComparisions = 0;
		numberOfAssignments = 0;
		
		int size = array.length;
		for (int pass = 1; pass < size; pass++)
		{
			for (int left=0; left < (size-pass); left++)
			{
				int right = left + 1;
				if (array[left] > array[right]) {
					int swapInt = array[left];
					array[left] = array[right];
					array[right] = swapInt;
					numberOfAssignments += 3;
				}
				numberOfComparisions ++;
			}
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
		return "BubbleSort";
	}
}